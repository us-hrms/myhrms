package com.hrms.hdp.util;

import java.io.IOException;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.util.Bytes;

import com.hrms.hdp.entity.ColumnInfo;


public class HbaseUtil {
	private Configuration config;
	
	private Connection conn;
	
	private Admin admin;
	
	private Table table;
	
	public HbaseUtil(){
		config = HBaseConfiguration.create();
		getConnection();
	}
	public HbaseUtil(Configuration conf){
		config = conf;
		getConnection();
	}
	
	/**
	 * ªÒµ√¡¥Ω”
	 */
	public Connection getConnection(){
		try {
			conn = ConnectionFactory.createConnection(config);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public Admin getAdmin(){
		if(conn == null)
			getConnection();
		try {
			admin = conn.getAdmin();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return admin;
	}
	
	public Table getTable(String tname){
		if(conn == null)
			getConnection();
		try {
			table = conn.getTable(TableName.valueOf(tname));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return table;
	}
	
	public boolean createTable(String tname,String... familyName){
		HTableDescriptor htd = new HTableDescriptor(TableName.valueOf(tname));
		//HColumnDescriptor hcd = new HColumnDescriptor(familyName);
		//htd.addFamily(hcd);
		for (String fn : familyName) {
			htd.addFamily(new HColumnDescriptor(fn));
		}
		try {
			if(admin == null)
				getAdmin();
			admin.createTable(htd);
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean insert(String tname,String rowkey,List<ColumnInfo> value){
		Table curTab = getTable(tname);
		Put put = new Put(Bytes.toBytes(rowkey));
		for (ColumnInfo cinfo : value) {
			put.addColumn(cinfo.getFamily(), cinfo.getQuolifire(), cinfo.getValue());
		}
		try {
			curTab.put(put);
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public void delete(String tname,String rowkey){
		Table curTab = getTable(tname);
		Delete del = new Delete(Bytes.toBytes(rowkey));
		try {
			curTab.delete(del);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Result get(String tname,String rowkey){
		Table curTab = getTable(tname);
		Get get = new Get(Bytes.toBytes(rowkey));
		try {
			return curTab.get(get);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultScanner scan(String tname){
		Table curTab = getTable(tname);
		try {
			return curTab.getScanner(new Scan());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public ResultScanner scan(String tname,String family,String... qualifire){
		Table curTab = getTable(tname);
		try {
			Scan scan = new Scan();
			for (String qua : qualifire) {
				scan.addColumn(Bytes.toBytes(family), Bytes.toBytes(qua));
			}
			return curTab.getScanner(scan);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public ResultScanner scan(String tname,ColumnInfo [] info){
		Table curTab = getTable(tname);
		try {
			Scan scan = new Scan();
			for (ColumnInfo columnInfo : info) {
				scan.addFamily(columnInfo.getFamily());
				scan.setFilter(new SingleColumnValueFilter(
						columnInfo.getFamily(), columnInfo.getQuolifire(), CompareOp.EQUAL, columnInfo.getValue()));
			}
			return curTab.getScanner(scan);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void show(Result result){
		List<Cell> cells = result.listCells();
		System.out.printf("======= %s =======\n",Bytes.toString(result.getRow()));
		for (Cell cell : cells) {
			System.out.printf("%s:%s = %s\n",Bytes.toString(CellUtil.cloneFamily(cell)),Bytes.toString(CellUtil.cloneQualifier(cell)),Bytes.toString(CellUtil.cloneValue(cell)));
		}
	}
	public void show(ResultScanner resultScan){
		for (Result result : resultScan) {
			show(result);
		}
	}
	
	public boolean existsTab(String tabName){
		if(admin == null)
			getAdmin();
		try {
			return admin.tableExists(TableName.valueOf(tabName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean dropTab(String tabName){
		if(admin == null)
			getAdmin();
		if(existsTab(tabName))
			try {
				if(admin.isTableEnabled(TableName.valueOf(tabName)))
					admin.disableTable(TableName.valueOf(tabName));
				admin.deleteTable(TableName.valueOf(tabName));
				return true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return false;
	}
	public boolean isEnabled(String tabName){
		try {
			return admin.isTableEnabled(TableName.valueOf(tabName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


}
