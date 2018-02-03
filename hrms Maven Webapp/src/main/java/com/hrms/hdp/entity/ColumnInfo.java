package com.hrms.hdp.entity;

import java.io.Serializable;

import org.apache.hadoop.hbase.util.Bytes;

public class ColumnInfo {
	private byte[] family;
	
	private byte[] quolifire;
	
	private byte[] value;
	
	

	public ColumnInfo() {
	}
	

	public ColumnInfo(String family,String quolifire,String value) {
		this.family = Bytes.toBytes(family);
		this.quolifire = Bytes.toBytes(quolifire);
		this.value = Bytes.toBytes(value);
	}

	public byte[] getFamily() {
		return family;
	}

	public void setFamily(byte[] family) {
		this.family = family;
	}
	public void setFamily(String family) {
		this.family = Bytes.toBytes(family);
	}

	public byte[] getQuolifire() {
		return quolifire;
	}
	public void setQuolifire(byte[] quolifire) {
		this.quolifire = quolifire;
	}
	public void setQuolifire(String quolifire) {
		this.quolifire = Bytes.toBytes(quolifire);
	}

	public byte[] getValue() {
		return value;
	}
	public void setValue(byte[] value) {
		this.value = value;
	}
	public void setValue(String value) {
		this.value = Bytes.toBytes(value);
	}
	
	
	
}
