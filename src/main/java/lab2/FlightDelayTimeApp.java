package lab2;


import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;

import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class FlightDelayTimeApp {
    public static void main(String[] args) throws Exception {
        Job job = Job.getInstance();
        job.setJarByClass(FlightDelayTimeApp.class);
        job.setJobName("Flight Delay Time App");

        

        job.setNumReduceTasks(2);
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}