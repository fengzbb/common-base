package com.zbb.common.base.response;

import java.io.Serializable;
import java.util.List;

/**
 * @Description:��ҳ���ؽ��
 * @author zbb
 * @param <T>
 * @date 2017��4��10�� ����10:10:08
 */
public class PageResponse<T> implements Serializable{
	
	//��ҳ��ѯ�ļ�¼
	private List<T> products;
	
	//��ǰҳ�� ���������pageRequest ���ݹ���
	private int pageNum;
	
	//����pageRequest ���ݹ���
	private int pageSize;
	
	//��һҳ
	private int beforePage;
	
	//��һҳ
	private int nextPage;
	
	//�ܼ�¼��
	private Long totalCounts;
	
	//��ҳ��
	private int totalPages;
	
	//�������� ��� ��ҳ��ҳ������
	private int[] pages;

	public List<T> getProducts() {
		return products;
	}

	public void setProducts(List<T> products) {
		this.products = products;
	}

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
	
	public Long getTotalCounts() {
		return totalCounts;
	}
	
	public void setTotalCounts(Long totalCounts) {
		this.totalCounts = totalCounts;
	}

	public int getBeforePage() {
		return this.pageNum > 1 ? this.pageNum - 1 : 1;
	}

	public int getNextPage() {
		return this.pageNum < this.totalPages ? this.pageNum + 1 : this.totalPages;
	}

	public int getTotalPages() {
		return (int)((this.totalCounts + this.pageSize - 1)/this.pageSize);
	}

	public int[] getPages() {
		int start; 
		int end;
		
		if(this.totalPages <= 10){
			start = 1;
			end = this.totalPages;
		}else{
			start = this.pageNum - 5;
			end = this.pageNum + 4;
		}
		if(start <= 0){
			start = 1;
			end = start + 9;
		}else if(end >= this.totalPages){
			end = this.totalPages;
			start = this.totalPages - 9;
		}
		pages = new int[end - start + 1];
		int index = 0;
		for(int i=start; i<=end; i++){
			pages[index++] = i;
		}
		return pages;
	}

}
