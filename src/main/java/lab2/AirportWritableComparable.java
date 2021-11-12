package lab2;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class AirportWritableComparable implements WritableComparable {
    private int airportCode;
    private int indicator;

    public AirportWritableComparable(int airportCode, int indicator) {
        this.airportCode = airportCode;
        this.indicator = indicator;
    }

    public int getAirportCode() {
        return airportCode;
    }

    public int getIndicator() {
        return indicator;
    }

    @Override
    public int compareTo(Object object) {
        if (this.airportCode != ((AirportWritableComparable) object).airportCode) {
            return Integer.compare(this.airportCode, ((AirportWritableComparable) object).airportCode);
        }
        else return Integer.compare(this.indicator, ((AirportWritableComparable) object).indicator);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
      airportCode = dataInput.readInt();
      indicator = dataInput.readInt();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.write(airportCode);
        dataOutput.write(indicator);
    }
}