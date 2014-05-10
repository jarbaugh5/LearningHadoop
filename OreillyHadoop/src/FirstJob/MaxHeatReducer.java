package FirstJob;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/*
 * The code in this file comes directly from Example 2-4
 * in Hadoop The Definitive Guide by Tom White
 */
public class MaxHeatReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
	
	@Override
	public void reduce(Text key, Iterable<IntWritable> values, Context context) 
		throws IOException, InterruptedException {
		
		int maxValue = Integer.MIN_VALUE;
		for (IntWritable value : values) {
			maxValue = Math.max(maxValue, value.get());
		}
		context.write(key, new IntWritable(maxValue));
	}
}
