package com.zbb.common.base.request;

import java.io.Serializable;

/**
 * @Description:分页请求参数
 * @author zbb
 * @date 2017年4月10日 上午10:02:08
 */
public class PageRequest implements Serializable{
	
	private static final long serialVersionUID = -1218479710871459052L;

	// 分页查询 当前页码
	private int pageNum = 1;
	
	// 分页查询 每页显示记录数 计算 select * from products limit ?,10
	private int pageSize = 10;
	
	// 起始记录数
	private int startIndex;

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStartIndex() {
		return (this.pageNum - 1) * pageSize;
	}
	
}
