package sos.haruhi.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import sos.haruhi.hadoop.job.MyMapper;
import sos.haruhi.hadoop.job.MyReducer;

import java.io.IOException;

/**
 * 本地提交，单机自测
 */
public class AppLocal {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        System.setProperty("hadoop.home.dir", "G:\\hadoop-3.2.2");
        System.setProperty("HADOOP_USER_NAME", "hadoop");
        Configuration conf = new Configuration(true);
        // 异构平台任务提交配置（windows 平台配置）
        conf.set("mapreduce.app-submission.cross-platform", "true");
        // 本地运行
        conf.set("mapreduce.framework.name", "local");
        // Create a new Job
        Job job = Job.getInstance(conf);
        // 此处必须配置，否则 job 集群卡住，无法执行，FAILED，  确定本地要提交的 jar 包
//        job.setJar("S:\\seatone-bigdata\\hadoop\\hadoop-test\\target\\hadoop-test-2.0-SNAPSHOT.jar");
        // 确定 Main class
        job.setJarByClass(AppLocal.class);

        // Specify various job-specific parameters
        job.setJobName("myjob");

//        job.setInputPath(new Path("in"));
//        job.setOutputPath(new Path("out"));

        // 输入文件
        Path infile = new Path("/text/data.txt");
        TextInputFormat.addInputPath(job, infile);

        // 输出文件
        Path outfile = new Path("/text/output5");
        TextOutputFormat.setOutputPath(job, outfile);

        // 判断输出路径是否为空
        if (outfile.getFileSystem(conf).exists(outfile)) {
            // 不为空直接清空
            outfile.getFileSystem(conf).delete(outfile, true);
        }

        job.setMapperClass(MyMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
        job.setReducerClass(MyReducer.class);

        // Submit the job, then poll for progress until the job is complete
        job.waitForCompletion(true);
    }
}
