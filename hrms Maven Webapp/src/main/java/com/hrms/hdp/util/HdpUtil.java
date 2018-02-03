package com.hrms.hdp.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FileUtil;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

public class HdpUtil {

	private  FileSystem fs;
	
	public HdpUtil(){
		try {
			fs = FileSystem.newInstance(new Configuration());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public HdpUtil(Configuration config){
		try {
			fs = FileSystem.newInstance(config);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public HdpUtil(Configuration config,String uri){
		try {
			fs = FileSystem.newInstance(URI.create(uri), config);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 	 * @param path
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
	 *  * @param path
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
			if(exists(path))
				delete(path);
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
	public boolean mkdir(String path){
		try {
			if(exists(path))
				delete(path);
			return fs.mkdirs(new Path(path));
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
	 *  @param path
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
	
	/**
	 * hdfs 内部复制
	 * 将文件复制到文件夹
	 * @param source
	 * @param target
	 * @return
	 */
	public boolean copy(String source,String target){
		return copy(new Path(source),new Path(target));
	}
	private boolean copy(Path source,Path target){
		try {
			if(!fs.exists(source))
				return false;
			if(!fs.exists(target))
				fs.mkdirs(target);
			return FileUtil.copy(fs, source, fs, target, false, new Configuration());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * hdfs 内部复制
	 * 将文件夹内文件复制到新文件夹
	 * @param source
	 * @param target
	 * @return
	 */
	public boolean copyDir(String source,String target){
		try {
			FileStatus [] statiuses = fs.listStatus(new Path(source));
			Path path = new Path(target);
			for (FileStatus status : statiuses) {
				if(status.isDirectory())
					continue;
				copy(status.getPath(),path);
			}
			return true;
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
		return false;
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
			fs.copyToLocalFile(false,new Path(source), new Path(target),true);
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
			IOUtils.copyBytes(is, System.out, 4096,true);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

