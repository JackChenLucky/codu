package cn.jack.codu.modules.system.model.vo;

import cn.jack.codu.modules.system.model.SysUser;

/**
 * 系统用户
 * @author JackChen
 *
 */
public class SysUserVo extends SysUser {
	
	private String expiredate_str;
	
	private String birthday_str;
	
	private String status_nm;
	
	private String dept_nm;

	public String getExpiredate_str() {
		return expiredate_str;
	}

	public void setExpiredate_str(String expiredate_str) {
		this.expiredate_str = expiredate_str;
	}

	public String getBirthday_str() {
		return birthday_str;
	}

	public void setBirthday_str(String birthday_str) {
		this.birthday_str = birthday_str;
	}

	public String getStatus_nm() {
		return status_nm;
	}

	public void setStatus_nm(String status_nm) {
		this.status_nm = status_nm;
	}

	public String getDept_nm() {
		return dept_nm;
	}

	public void setDept_nm(String dept_nm) {
		this.dept_nm = dept_nm;
	}
	
	
}
