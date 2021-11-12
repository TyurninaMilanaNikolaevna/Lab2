package lab2;

public class FlightDelayTimeApp {
    public static void main(String[] args) throws Exception {
        Job job = Job.getInstance();
        job.setJarByClass(FlightDelayTimeApp.class);
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        

    }
}