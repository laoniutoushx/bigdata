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

/*
// 实时数据

phd 每分钟 有个值     tag      time（min）       value

按天分布到 hdfs 文件系统

最近一个月、一年内 实时数据 进行分析，（挑一个 测点  数据运行 有效区间） 数据 标准差 方差 计算
卡边优化  min 160   ~   max 180

通过历史数据  计算  数据 边界值、临界值
 */


/**
 * 集群方式提交
 * 在 windows 提交，在 yarn hadoop 集群环境中运行
 */
public class App {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        System.setProperty("HADOOP_USER_NAME", "hadoop");

        Configuration conf = new Configuration(true);
        // 异构平台任务提交配置
        conf.set("mapreduce.app-submission.cross-platform", "true");
        // 以 hostname 方式连接集群
        conf.set("dfs.client.use.datanode.hostname", "true");
        // 不检查超时
        conf.set("mapred.task.timeout", "0");

        // Create a new Job
        Job job = Job.getInstance(conf);
        // 此处必须配置，否则 job 集群卡住，无法执行，FAILED，  确定本地要提交的 jar 包
        job.setJar("S:\\seatone-bigdata\\hadoop\\hadoop-test\\target\\hadoop-test-2.0-SNAPSHOT.jar");
        // 确定 Main class
        job.setJarByClass(App.class);

        // Specify various job-specific parameters
        job.setJobName("myjob");

//        job.setInputPath(new Path("in"));
//        job.setOutputPath(new Path("out"));

        // 输入文件
        Path infile = new Path("/text/data.txt");
        TextInputFormat.addInputPath(job, infile);

        // 输出文件
        Path outfile = new Path("/text/output");
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
