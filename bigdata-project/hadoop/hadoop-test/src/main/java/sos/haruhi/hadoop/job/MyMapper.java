package sos.haruhi.hadoop.job;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.StringTokenizer;

public class MyMapper extends Mapper<Object, Text, Text, IntWritable> {
    // hadoop 框架， 分布式、数据、序列化、反序列化

    // 自己开发 IntWritable 需要 序列化、反序列化及比较器接口

    private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();

    // hello hadoop
    // hello mapreduce

    /**
     *
     * @param key       每行字符串 第一个字节 面向 源文件的 偏移量
     * @param value     字符串
     * @param context
     * @throws IOException
     * @throws InterruptedException
     */
    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        // 正则切割，this(var1, " \t\n\r\f", false)，返回切割后的 迭代器
        StringTokenizer itr = new StringTokenizer(value.toString());
        while (itr.hasMoreTokens()) {
            word.set(itr.nextToken());
            context.write(word, one);
        }
    }
}
