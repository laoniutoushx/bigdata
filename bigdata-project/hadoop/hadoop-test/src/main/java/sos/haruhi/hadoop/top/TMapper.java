package sos.haruhi.hadoop.top;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

// 输入       输入    输出    输出
public class TMapper extends Mapper<LongWritable, Text, TKey, IntWritable> {

    TKey tKey = new TKey();
    IntWritable tVal = new IntWritable();

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, TKey, IntWritable>.Context context) throws IOException, InterruptedException {
        //              日期            地区   温度
        // value: 2019-6-1 22:22:22     1     31
        String[] strs = StringUtils.split(value.toString(), '\t');
        // 2019-6-1 22:22:22
        try {
            Date date = DateUtils.parseDate(strs[0], "yyyy-MM-dd HH:mm:ss");
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            tKey.setYear(cal.get(Calendar.YEAR));
            tKey.setMonth(cal.get(Calendar.MONTH - 1));
            tKey.setDay(cal.get(Calendar.DAY_OF_MONTH));
            int temperature = Integer.parseInt(strs[2]);
            tKey.setWd(temperature);
            tVal.set(temperature);

            context.write(tKey, tVal);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
