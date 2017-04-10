package com.zbb.common.base.request;

import java.io.Serializable;

/**
 * @Description:��ҳ�������
 * @author zbb
 * @date 2017��4��10�� ����10:02:08
 */
public class PageRequest implements Serializable{
	
	private static final long serialVersionUID = -1218479710871459052L;

	// ��ҳ��ѯ ��ǰҳ��
	private int pageNum = 1;
	
	// ��ҳ��ѯ ÿҳ��ʾ��¼�� ���� select * from products limit ?,10
	private int pageSize = 10;
	
	// ��ʼ��¼��
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
