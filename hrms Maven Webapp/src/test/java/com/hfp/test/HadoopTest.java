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
		 *  ��ʹ��copyToLocalFile(Path src, Path dst)����ʱ���ܵ��� setPermission�ļ������ļ�Ч��ʧ��.   

		      ���ʹ��copyToLocalFile( boolean delSrc,Path src, Path dst, boolean useRawLocalFileSystem)
		
         boolean delSrc ָ�Ƿ�ԭ�ļ�ɾ��

         Path src ָҪ���ص��ļ�·��

         Path dst ָ���ļ����ص���·��

         boolean useRawLocalFileSystem �Ƿ����ļ�Ч��
		 * 
		 */
		Assert.assertEquals(hu.copyToLocal("hdfs://node1:9000/java/test.txt", "E:/Workspaces/MyEclipse 2015/hadoop/test"), true);
	}

	//���û�������  HADOOP_USER_NAME Ϊ Hadoop���õ��û�  ��������Ȩ�޲����Ĵ���
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
