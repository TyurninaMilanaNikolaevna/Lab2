package lab2;

import org.apache.hadoop.io.WritableComparator;

public class GroupingComparator extends WritableComparator {

    public GroupingComparator() {
        super(AirportWritableComparable.class, true);
    }

    @Override
    public int compare (Object a, Object b) {
        return Integer.compare(((AirportWritableComparable) a).getAirportCode(), ((AirportWritableComparable) b).getAirportCode());
    }
}