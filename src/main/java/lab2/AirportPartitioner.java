package lab2;

import org.apache.hadoop.mapreduce.Partitioner;

public class AirportPartitioner extends Partitioner<AirportWritableComparable, Text> {
    @Override
    public int getPartition(AirportWritableComparable airportWritableComparable, Text text, int i) {
        return 0;
    }
}