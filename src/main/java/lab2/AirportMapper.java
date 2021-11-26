package  lab2;

import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;

import java.io.IOException;

public class AirportMapper extends Mapper <LongWritable, Text, AirportWritableComparable, Text> {

    public static int AIRPORT_CODE_POSITION = 0;
    public static int AIRPORT_DESCRIPTION_POSITION = 1;
    public static int INDICATOR = 0;
    public static final String SPLITTER = ",";

    @Override
    protected void map(LongWritable key, Text value, Mapper <LongWritable, Text, AirportWritableComparable, Text>.Context context) throws IOException, InterruptedException {
        String[] airportCodeAndDescription = value.toString()
                .replaceAll("\"", "")
                .split(SPLITTER);
        if (key.get() > 0) {
            int airportCode = Integer.parseInt(airportCodeAndDescription[AIRPORT_CODE_POSITION]);
            String airportDescription = airportCodeAndDescription[AIRPORT_DESCRIPTION_POSITION];
            context.write(new AirportWritableComparable(airportCode, INDICATOR), new Text(airportDescription));
        }
    }
}

