package lab2;

import org.apache.hadoop.io.WritableComparable;

public class GroupingComparatorClass extends WritableComparable {


    @Override
    public int compare (Object a, Object b) {
        return Integer.compare(((AirportWritableComparable) a).getAirportCode, ((AirportWritableComparable) b).getAirportCode);
    }
}