package cn.jack.codu.modules.system.model;

import java.util.ArrayList;
import java.util.List;

public class MenuTree extends SysMenu{

	private int treeLevel;

	private List<MenuTree> subMenus = new ArrayList<MenuTree>();

	public List<MenuTree> getSubMenus() {
		return subMenus;
	}

	public void setSubMenus(List<MenuTree> subMenus) {
		this.subMenus = subMenus;
	}
	

	public int getTreeLevel() {
		return treeLevel;
	}

	public void setTreeLevel(int treeLevel) {
		this.treeLevel = treeLevel;
	}
	
}
