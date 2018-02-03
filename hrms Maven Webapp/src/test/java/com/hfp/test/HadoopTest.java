package com.hfp.test;

import org.junit.Assert;
import org.junit.Test;

import com.hrms.hdp.util.HdpUtil;
public class HadoopTest {
	private HdpUtil hu = new HdpUtil();

	public void exists(){
		Assert.assertEquals(hu.exists("hdfs://node1:9000/java"), true);
	}

	public void list(){
		hu.list("hdfs://node1:9000/java/HeUtil.java");
	}

	public void cat(){
		hu.cat("hdfs://node1:9000/java/test2.txt");
	}
	
	
	public void copyto(){
		/*
		 *  在使用copyToLocalFile(Path src, Path dst)方法时可能导致 setPermission文件本地文件效验失败.   

		      因此使用copyToLocalFile( boolean delSrc,Path src, Path dst, boolean useRawLocalFileSystem)
		
         boolean delSrc 指是否将原文件删除

         Path src 指要下载的文件路径

         Path dst 指将文件下载到的路径

         boolean useRawLocalFileSystem 是否开启文件效验
		 * 
		 */
		Assert.assertEquals(hu.copyToLocal("hdfs://node1:9000/java/test.txt", "E:/Workspaces/MyEclipse 2015/hadoop/test"), true);
	}

	//配置环境变量  HADOOP_USER_NAME 为 Hadoop配置的用户  否则会出现权限不够的错误
	public void create(){
		Assert.assertEquals(hu.create("hdfs://node1:9000/java/testWord.txt", "word word hellow nihao ni hao ni hao hellow hellow"), true);
	}
	
	public void copy(){
		//hu.mkdir("hdfs://node1:9000/java/demo");
		Assert.assertEquals(hu.copyDir("hdfs://node1:9000/java", "hdfs://node1:9000/java/demo2"), true);
	}

	public void del(){
		Assert.assertEquals(hu.delete("hdfs://node1:9000/java/demo2"), true);
	}

	
}
