package cn.jack.codu.modules.druguse.model.vo;

import cn.jack.codu.common.model.PageBean;

public class DrugInfoSearch  extends PageBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String drugname;

	public String getDrugname() {
		return drugname;
	}

	public void setDrugname(String drugname) {
		this.drugname = drugname;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
