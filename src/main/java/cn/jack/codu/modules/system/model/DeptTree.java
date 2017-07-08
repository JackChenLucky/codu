package cn.jack.codu.modules.system.model;

import java.util.ArrayList;
import java.util.List;

public class DeptTree extends SysDept {

	private List<DeptTree> subDepts = new ArrayList<DeptTree>();

	public List<DeptTree> getSubDepts() {
		return subDepts;
	}

	public void setSubDepts(List<DeptTree> subDepts) {
		this.subDepts = subDepts;
	}
}
