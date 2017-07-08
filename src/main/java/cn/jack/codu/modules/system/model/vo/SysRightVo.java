package cn.jack.codu.modules.system.model.vo;

import cn.jack.codu.modules.system.model.SysFunc;
import cn.jack.codu.modules.system.model.SysMenu;

/**
 * 权限实体封装，菜单和功能点共同组织成用户的权限
 * @author JackChen
 *
 */
public class SysRightVo {
	/*权限标识*/
	private String rightFlag;
	/*权限菜单*/
	private SysMenu menus;
	/*权限功能*/
	private SysFunc funcs;

	public String getRightFlag() {
		return rightFlag;
	}

	public void setRightFlag(String rightFlag) {
		this.rightFlag = rightFlag;
	}

	public SysMenu getMenus() {
		return menus;
	}

	public void setMenus(SysMenu menus) {
		this.menus = menus;
	}

	public SysFunc getFuncs() {
		return funcs;
	}

	public void setFuncs(SysFunc funcs) {
		this.funcs = funcs;
	}
	
}
