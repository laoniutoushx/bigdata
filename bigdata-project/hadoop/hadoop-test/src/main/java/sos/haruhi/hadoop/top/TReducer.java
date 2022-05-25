package sos.haruhi.hadoop.top;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class TReducer extends Reducer<TKey, IntWritable, Text, IntWritable> {


    Text rKey = new Text();
    IntWritable rVal = new IntWritable();

    @Override
    protected void reduce(TKey key, Iterable<IntWritable> values, Reducer<TKey, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {
        // TKey 年月日+温度
        // 1970-6-4     33  33  28  29
        // 1970-6-22     32 25
        // 1970-6-12     27 38  24
        // 1970-6-15     36 36  27  29

        // 对 values 进行迭代，  key 是否发生变化？？？

        int flg = 0;    //  是否第一次循环
        int day = 0;    //  日期判断
        Iterator<IntWritable> iterator = values.iterator();
        while (iterator.hasNext()) {
            IntWritable val = iterator.next();

            if (flg == 0) {
                rKey.set(key.getYear() + "-" + key.getMonth() + "-" + key.getDay());
                rVal.set(key.getWd());
                context.write(rKey, rVal);
                flg++;
                day = key.getDay();
            }

            // 不是第一次循环，且 日期不同，则输出
            if(flg != 0 && day != key.getDay()){
                rKey.set(key.getYear() + "-" + key.getMonth() + "-" + key.getDay());
                rVal.set(key.getWd());
                context.write(rKey, rVal);
                break;
            }
        }

    }
}
