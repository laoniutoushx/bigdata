package sos.haruhi.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;
import sos.haruhi.hadoop.top.*;

import java.io.IOException;

public class TopN {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        System.setProperty("hadoop.home.dir", "G:\\hadoop-3.2.2");
        System.setProperty("HADOOP_USER_NAME", "hadoop");
        Configuration conf = new Configuration(true);
        // 异构平台任务提交配置（windows 平台配置）
        conf.set("mapreduce.app-submission.cross-platform", "true");
        // 本地运行
        conf.set("mapreduce.framework.name", "local");

        String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();

        Job job = Job.getInstance(conf);
        job.setJarByClass(TopN.class);


        job.setJobName("topN");

        // map task

        // input
        TextInputFormat.addInputPath(job, new Path(otherArgs[0]));  // 输入
        Path outPath = new Path(otherArgs[1]);

        if (outPath.getFileSystem(conf).exists(outPath)) {
            outPath.getFileSystem(conf).delete(outPath, true);
        }
        TextOutputFormat.setOutputPath(job, outPath);
        // key
        // map
        job.setMapperClass(TMapper.class);
        job.setMapOutputKeyClass(TKey.class);
        job.setMapOutputValueClass(IntWritable.class);

        // partitioner  按   年   月   分区 -> 分区 > 分组  按 年分区
        job.setPartitionerClass(TPartitioner.class);    // 划分分区器
        // sortComparator
        job.setSortComparatorClass(TSortComparator.class);

        // combine

        // reduce task
        // shuffle

        // groupingComparator
        job.setGroupingComparatorClass(TGroupingComparator.class);
        // reduce
        job.setReducerClass(TReducer.class);

        // Submit the job, then poll for progress until the job is complete
        job.waitForCompletion(true);
    }
}
