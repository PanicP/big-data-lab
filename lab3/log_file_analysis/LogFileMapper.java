package stubs;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

public class LogFileMapper
  extends Mapper<LongWritable, Text, Text, IntWritable> {

  private static final IntWritable one = new IntWritable(1);
  private Text ipAddress = new Text();

  @Override
  public void map(LongWritable key, Text value, Context context)
    throws IOException, InterruptedException {
    String line = value.toString();

    String[] fields = line.split("\\s+");

    ipAddress.set(fields[0]);

    context.write(ipAddress, one);
  }
}
// package stubs;
// import java.io.IOException;
// import org.apache.hadoop.io.IntWritable;
// import org.apache.hadoop.io.LongWritable;
// import org.apache.hadoop.io.Text;
// import org.apache.hadoop.mapreduce.Mapper;
// /**
//  * Example input line:
//  * 96.7.4.14 - - [24/Apr/2011:04:20:11 -0400] "GET /cat.jpg HTTP/1.1" 200 12433
//  *
//  */
// public class LogFileMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
//   @Override
//   public void map(LongWritable key, Text value, Context context)
//       throws IOException, InterruptedException {
//     /*
//      * TODO implement
//      */
//   }
// }
