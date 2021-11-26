package lab2;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class AirportReducer extends Reducer<AirportWritableComparable, Text, Text, Text> {

    @Override
    protected void reduce(AirportWritableComparable key, Iterable<Text> values, Reducer<AirportWritableComparable, Text, Text, Text>.Context context) throws IOException, InterruptedException {

        float minDelayTime = Float.MAX_VALUE;
        float maxDelayTime = 0;
        float sumDelayTime = 0;
        float averageDelayTime = 0;

        int counter = 0;

        Iterator<Text> iterator = values.iterator();
        Text airportDescription = new Text(iterator.next());

        while (iterator.hasNext()) {
            float delayTime = Float.parseFloat(iterator.next().toString());
            if (delayTime < minDelayTime) {
                minDelayTime = delayTime;
            }
            if (delayTime > maxDelayTime) {
                maxDelayTime = delayTime;
            }

            counter++;
            sumDelayTime += delayTime;
            averageDelayTime = sumDelayTime / counter;
        }

        if (counter > 0) {
            String answer = "Min Delay Time: " + minDelayTime +
                    "\nMax Delay Time: " + maxDelayTime +
                    "\nAverage Delay Time: " + averageDelayTime;
            context.write(airportDescription, new Text(answer));
        }
    }
}