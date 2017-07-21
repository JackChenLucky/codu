package cn.jack.codu.modules.druguse.model.vo;

import cn.jack.codu.modules.druguse.model.KzDrugSet;

public class DrugsetVo extends KzDrugSet {

	private String drugname;
	
	private String usetypename;
	
	private String sourcename;
	
	private String kzlevelname;
	
	private String useflagname;
	
	public String getUseflagname() {
		return useflagname;
	}

	public void setUseflagname(String useflagname) {
		this.useflagname = useflagname;
	}

	public String getDrugname() {
		return drugname;
	}

	public void setDrugname(String drugname) {
		this.drugname = drugname;
	}

	public String getUsetypename() {
		return usetypename;
	}

	public void setUsetypename(String usetypename) {
		this.usetypename = usetypename;
	}

	public String getSourcename() {
		return sourcename;
	}

	public void setSourcename(String sourcename) {
		this.sourcename = sourcename;
	}

	public String getKzlevelname() {
		return kzlevelname;
	}

	public void setKzlevelname(String kzlevelname) {
		this.kzlevelname = kzlevelname;
	}
	
	
}
