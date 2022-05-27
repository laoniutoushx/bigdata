package sos.haruhi.etl;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class GulivideoETLMapper extends Mapper<LongWritable, Text,Text, NullWritable> {
    Text outk = new Text();
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();

        String result = ETLUtils.etlGulivideoData(line);

        if(result == null){
            return ;
        }
        outk.set(result);

        context.write(outk,NullWritable.get());
    }
}
