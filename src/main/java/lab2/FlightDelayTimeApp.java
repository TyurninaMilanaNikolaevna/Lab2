package lab2;




public class FlightDelayTimeApp {
    public static void main(String[] args) throws Exception {
        Job job = Job.getInstance();
        job.setJarByClass(FlightDelayTimeApp.class);
        job.setJobNane("Flight Delay Time App");


        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}