package lab2;

import java.io.IOException;
import java.util.Iterator;

public class AirportReducer {

    protected void reduce(AirportWritableComparable key, Iterable<Text> values, Reducer<AirportWritableComparable, Text, Text, Text>.Context context) throws IOException, InterruptedException {
        Iterator<Text> iterator
    }
}