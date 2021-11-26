package lab2;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class AirportWritableComparable implements WritableComparable {
    private int airportCode;
    private int indicator;

    public AirportWritableComparable() {}

    public AirportWritableComparable(int airportCode, int indicator) {
        this.airportCode = airportCode;
        this.indicator = indicator;
    }

    public int getAirportCode() {
        return airportCode;
    }

    @Override
    public int compareTo(Object object) {
        int objectAirportCode = ((AirportWritableComparable) object).airportCode;
        int objectIndicator = ((AirportWritableComparable) object).indicator;

        if (this.airportCode != objectAirportCode) {
            return Integer.compare(this.airportCode, objectAirportCode);
        }
        else return Integer.compare(this.indicator, objectIndicator);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
      airportCode = dataInput.readInt();
      indicator = dataInput.readInt();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(airportCode);
        dataOutput.writeInt(indicator);
    }
}