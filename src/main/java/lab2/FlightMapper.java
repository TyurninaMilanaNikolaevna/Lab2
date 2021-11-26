package lab2;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlightMapper extends Mapper<LongWritable, Text, AirportWritableComparable, Text> {

    public static int DEST_AIRPORT_ID_POSITION = 14;
    public static int ARR_DELAY_POSITION = 18;
    public static int INDICATOR = 1;
    public static float ZERO = 0;
    public static final String SPLITTER = ",";


    @Override
    protected void map(LongWritable key, Text value, Mapper <LongWritable, Text, AirportWritableComparable, Text>.Context context) throws IOException, InterruptedException {
        String[] flightDescription = value.toString()
                .replace("\"", "")
                .split(SPLITTER);
        if (key.get() > 0) {
            int airportCode = Integer.parseInt(flightDescription[DEST_AIRPORT_ID_POSITION]);
            String flightDelay = flightDescription[ARR_DELAY_POSITION];
            if (!flightDelay.isEmpty() && Float.parseFloat(flightDelay) != ZERO) {
                context.write(new AirportWritableComparable(airportCode, INDICATOR), new Text(flightDelay));
            }
        }
    }
}