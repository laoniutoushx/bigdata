package sos.haruhi.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.net.URI;
import java.nio.charset.StandardCharsets;

public class TestHDFS {

    public Configuration conf = null;

    public FileSystem fs = null;


    @Before
    public void conn() throws IOException, InterruptedException {
        conf = new Configuration(true);

        conf.set("fs.defaultFS", "hdfs://192.168.5.32:9000/");
        conf.set("dfs.client.use.datanode.hostname", "true");

//        fs = FileSystem.get(conf);
        // schema
        /**
         * <property>
         *         <name>fs.default.name</name>
         *         <value>hdfs://h01:9000</value>
         *     </property>
         */
        // 取环境变量 HADOOP_USERNAME 值
        fs = FileSystem.get(URI.create("hdfs://192.168.5.32:9000"), conf, "hadoop");
        System.setProperty("HADOOP_USER_NAME", "hadoop");


    }


    @Test
    public void mkdir() throws IOException {

        Path dir = new Path("/seatone");
        if (fs.exists(dir)) {
            fs.delete(dir, true);
        }
        fs.mkdirs(dir);

    }

    @Test
    public void upload() throws IOException {


        BufferedInputStream input = new BufferedInputStream(new FileInputStream(new File("S:/data.txt")));

        Path outfile = new Path("/seatone/hello.txt");
        FSDataOutputStream output = fs.create(outfile);

        IOUtils.copyBytes(input, output, conf, true);
    }

    @Test
    public void download() throws IOException {


        Path inputFile = new Path("/shx/hello.txt");
        FSDataInputStream input = fs.open(inputFile);

        BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(new File("S:/out.txt")));

        IOUtils.copyBytes(input, output, conf, true);
    }

    @Test
    public void blocks() throws IOException {
        Path file = new Path("/shx/dpcq.txt");
        FileStatus fas = fs.getFileStatus(file);
        long blockSize = fas.getBlockSize();

        BlockLocation[] fileBlockLocations = fs.getFileBlockLocations(fas, 0, fas.getLen());
        for (BlockLocation fileBlockLocation : fileBlockLocations) {
            System.out.println(fileBlockLocations);
        }

        FSDataInputStream in = fs.open(file);

        byte[] bytes = new byte[200];
        in.read(bytes);

        System.out.println(new String(bytes, StandardCharsets.UTF_8));

        // 偏移 到 第二个块开头bytes = new byte[200];
        //        in.read(bytes);
        //
        //        System.out.println(new String(bytes, StandardCharsets.UTF_8));
        in.seek(blockSize);


    }


    @After
    public void close() {

    }

}
