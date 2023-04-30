package stubs;

import java.io.IOException;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class LogFileReducer
  extends Reducer<Text, IntWritable, Text, DoubleWritable> {

  //  @Override
  //  public void reduce(Text key, Iterable<IntWritable> values, Context context)
  //      throws IOException, InterruptedException {
  //
  //    /*
  //     * TODO implement
  //     */
  //
  //  }
  @Override
  public void reduce(Text key, Iterable<IntWritable> values, Context context)
    throws IOException, InterruptedException {
    long wordLengthSum = 0;
    long wordCount = 0;

    for (IntWritable value : values) {
      wordLengthSum += value.get();
      wordCount++;
    }
    if (wordCount != 0) {
      double result = (double) wordLengthSum / (double) wordCount;
      context.write(key, new DoubleWritable(result));
    }
  }
}
