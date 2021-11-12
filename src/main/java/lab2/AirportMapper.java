package  lab2;

import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;

import java.io.IOException;

public class AirportMapper extends Mapper <LongWritable, Text, AirportWritableComparable, Text> {

    public static int AIRPORT_CODE_POSITION = 0;
    public static int AIRPORT_DESCRIPTION_POSITION = 1;

    @Override
    protected void map() throws IOException, InterruptedException {

    }
}

