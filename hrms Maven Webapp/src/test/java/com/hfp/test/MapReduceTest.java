package com.hfp.test;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.junit.Test;

import com.hrms.hdp.util.HdpUtil;

public class MapReduceTest {
	public static class MyMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
		@Override
		protected void map(LongWritable key, Text value,Context context)
				throws IOException, InterruptedException {
			// TODO Auto-generated method stub
			IntWritable outVal = new IntWritable(1);
			StringTokenizer token = new StringTokenizer(value.toString());
			while(token.hasMoreTokens())
				context.write(new Text(token.nextToken()), outVal);
		}
	}
	
	public static class MyReduce extends Reducer<Text, IntWritable, Text, IntWritable>{

		@Override
		protected void reduce(Text key, Iterable<IntWritable> value,Context context)
				throws IOException, InterruptedException {
			// TODO Auto-generated method stub
			int sum = 0;
			for (IntWritable intWritable : value)
				sum += intWritable.get();
			context.write(key, new IntWritable(sum));
		}
	}
	public static void main(String[] args) {
		wordCount();
	}
	
	public static void wordCount(){
		Configuration conf = new Configuration();
		HdpUtil hu = new HdpUtil(conf);
		try {
			Job job = new Job(conf,"wordcount");
			job.setJarByClass(MapReduceTest.class);
			job.setMapperClass(MyMapper.class);
			job.setReducerClass(MyReduce.class);
			//job.setInputFormatClass(TextInputFormat.class);
			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(IntWritable.class);
			String out = "hdfs://node1:9000/java/result";
			FileInputFormat.addInputPath(job, new Path("hdfs://node1:9000/java/testWord.txt"));
			if(hu.exists(out))
				hu.delete(out);
			FileOutputFormat.setOutputPath(job, new Path("hdfs://node1:9000/java/result"));
			job.waitForCompletion(true);
			System.exit(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
