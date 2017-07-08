package cn.jack.codu.modules.system.model.vo;

import cn.jack.codu.common.model.PageBean;

public class DeptSearchVo extends PageBean{

	private String deptname;
	
	private String status;

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
