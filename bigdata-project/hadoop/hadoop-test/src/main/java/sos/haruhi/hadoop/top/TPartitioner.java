package sos.haruhi.hadoop.top;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Partitioner;

public class TPartitioner extends Partitioner<TKey, IntWritable> {
    @Override
    public int getPartition(TKey tKey, IntWritable intWritable, int numPartitions) {
        // 分区器设计不能复杂
        // 相同年份的记录 分区到一组
        return tKey.getYear() % numPartitions;  // 数据可能倾斜
    }
}
