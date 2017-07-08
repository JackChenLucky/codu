package cn.jack.codu.common.model;

import java.io.Serializable;

/**
 * 分页基类封装
 * @author JackChen
 *
 */
public class PageBean implements Serializable{
	
	private static final long serialVersionUID = -2113525961847707803L;

	private int pageNum = 1;
	
	private int numPerPage = 20;
	
	private String orderField;
	
	private String orderDirection;
	

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}

	public String getOrderField() {
		return orderField;
	}

	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}

	public String getOrderDirection() {
		return orderDirection;
	}

	public void setOrderDirection(String orderDirection) {
		this.orderDirection = orderDirection;
	}
	
}