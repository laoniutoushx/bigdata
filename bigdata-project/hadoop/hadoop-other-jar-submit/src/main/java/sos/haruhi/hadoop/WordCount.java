package sos.haruhi.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class WordCount {

    public static class TokenizerMapper extends Mapper<Object, Text, Text, IntWritable> {

        private final static IntWritable one = new IntWritable(1);
        private Text word = new Text();

        public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
            StringTokenizer itr = new StringTokenizer(value.toString());
            while (itr.hasMoreTokens()) {
                word.set(itr.nextToken());
                context.write(word, one);
            }
        }
    }

    public static class IntSumReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
        private IntWritable result = new IntWritable();

        public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
            int sum = 0;
            for (IntWritable val : values) {
                sum += val.get();
            }
            result.set(sum);
            context.write(key, result);

//            List<String> strs = new ArrayList<>();
//            strs.add("shanghai    5     34");
//            strs.add("shanghai    5     33");
//            strs.add("shanghai    5     31");
//            strs.add("beijing    5     31");
//            strs.add("beijing    5     34");
//
//            // shanghai    5     34
//            // key:shanghai     34
//            // key:shanghai     34
//
//
//            //  / key:shanghai     34 33 3
//            strs.stream().collect(Collectors.gr())
//            Map<String, List<String> Max  m> map = new HashMap<>();

        }
    }

    public static void main(String[] args) throws Exception {
        System.setProperty("hadoop.home.dir", "G:\\hadoop-3.2.2");
        Configuration conf = new Configuration();
        GenericOptionsParser parser = new GenericOptionsParser(conf, args); // 过滤 args 中 -D 参数
        String[] otherArgs = parser.getRemainingArgs();    // 获取 其他 command 参数


        Job job = Job.getInstance(conf, "word count");
        job.setJarByClass(WordCount.class);
        job.setMapperClass(TokenizerMapper.class);
        job.setCombinerClass(IntSumReducer.class);
        job.setReducerClass(IntSumReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
//        FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
        FileInputFormat.addInputPath(job, new Path("S:\\seatone-bigdata\\hadoop\\hadoop-other-jar-submit\\src\\main\\resources\\wc.txt"));
//        FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));
        FileOutputFormat.setOutputPath(job, new Path("S:\\seatone-bigdata\\hadoop\\hadoop-other-jar-submit\\src\\main\\out"));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}