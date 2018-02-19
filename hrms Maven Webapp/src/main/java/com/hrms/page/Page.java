package com.hrms.page;

import java.io.Serializable;

/**
 * 页面数据类
 * @author hfp
 *
 */
public class Page implements Serializable {
	//页面显示数
	private Integer pageSize;
	//页码
	private Integer pageIndex;
	//总页数
	private Integer pageCount;
	public Page() {
		pageSize = 8;
		pageIndex = 1;
		// TODO Auto-generated constructor stub
	}
	public Page(Integer pageSize, Integer pageIndex, Integer count) {
		super();
		this.pageSize = pageSize;
		this.pageIndex = pageIndex;
		this.pageCount = count;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	
	/**
	 * 根据传入数目计算总页数
	 * @param size
	 */
	public void setPageCountBySize(Integer size) {
		this.pageCount = size%pageSize==0?size/pageSize:size/pageSize+1;
	}
	@Override
	public String toString() {
		return "Page [pageSize=" + pageSize + ", pageIndex=" + pageIndex
				+ ", pageCount=" + pageCount + "]";
	}
	
	
}
