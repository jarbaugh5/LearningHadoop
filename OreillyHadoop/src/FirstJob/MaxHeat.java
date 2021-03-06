package FirstJob;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/*
 * The code in this file comes directly from Example 2-5
 * in Hadoop The Definitive Guide by Tom White
 */
public class MaxHeat {
	
	public static void main(String args[]) throws Exception {
		if (args.length != 2) {
			System.err.println("Usage: MaxHeat <input path> <output path>");
			System.exit(-1);
		}
		
		Job job = new Job();
		job.setJarByClass(MaxHeat.class);
		job.setJobName("Max Heat");
		
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		job.setMapperClass(MaxHeatMapper.class);
		job.setReducerClass(MaxHeatReducer.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}

}
