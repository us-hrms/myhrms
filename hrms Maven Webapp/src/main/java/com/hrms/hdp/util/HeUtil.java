package com.hrms.hdp.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.io.util.StreamUtils;

public class HeUtil {
	
	private  FileSystem fs;
	
	public HeUtil(){
		try {
			fs = FileSystem.newInstance(new Configuration());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public HeUtil(Configuration config){
		try {
			fs = FileSystem.newInstance(config);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public HeUtil(Configuration config,String uri){
		try {
			fs = FileSystem.newInstance(URI.create(uri), config);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 判断是否存在
	 * @param path
	 * @return
	 */
	public boolean exists(String path){
		try {
			return fs.exists(new Path(path));
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	/**
	 * 存在就删除
	 * @param path
	 * @return
	 */
	public boolean delete(String path){
		try {
			return fs.delete(new Path(path), true);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public void create(String path){
		create(path,null);
	}
	public boolean create(String path,String content){
		OutputStream os = null;
		try {
			os = fs.create(new Path(path));
			if(content!=null){
				os.write(content.getBytes("UTF-8"));
				os.flush();
			}
			return true;
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(os != null)
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return false;
	}
	
	/**
	 * 查看目录下的目录或文件
	 * @param path
	 */
	public void list(String path){
		FileStatus[] list = null;
		try {
			list = fs.listStatus(new Path(path));
			for (FileStatus fileStatus : list) {
				System.out.printf("name:%s\tpath:%s\n",fileStatus.getPath().getName(),fileStatus.getPath().toString());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean copyFromLocal(String source,String target){
		try {
			fs.copyFromLocalFile(new Path(source), new Path(target));
			return true;
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean copyToLocal(String source,String target){
		try {
			fs.copyToLocalFile(new Path(source), new Path(target));
			return true;
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public void cat(String path){
		InputStream is = null;
		try {
			is = fs.open(new Path(path));
			
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}