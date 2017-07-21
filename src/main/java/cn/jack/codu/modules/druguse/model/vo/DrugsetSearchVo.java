package cn.jack.codu.modules.druguse.model.vo;

import cn.jack.codu.common.model.PageBean;

public class DrugsetSearchVo extends PageBean {

	/**
	 * 药品代码
	 */
	private String drugcode;
	
	private String drugname;
	
	private String usetype;
	
	public String getUsetype() {
		return usetype;
	}

	public void setUsetype(String usetype) {
		this.usetype = usetype;
	}

	public String getDrugcode() {
		return drugcode;
	}

	public void setDrugcode(String drugcode) {
		this.drugcode = drugcode;
	}

	public String getDrugname() {
		return drugname;
	}

	public void setDrugname(String drugname) {
		this.drugname = drugname;
	}
	
	
}
