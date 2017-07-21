package cn.jack.codu.modules.system.service.impl;

import cn.jack.codu.modules.system.model.MenuTree;
import cn.jack.codu.modules.system.model.SysMenu;
import cn.jack.codu.modules.system.model.vo.MenuSearchVo;
import cn.jack.codu.common.constants.SequenceConstants;
import cn.jack.codu.core.util.ToolUtil;
import cn.jack.codu.modules.system.dao.CommonMapper;
import cn.jack.codu.modules.system.dao.SysMenuMapper;
import cn.jack.codu.modules.system.service.ISysMenuService;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jackchen
 * @since 2017-07-08
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {
	@Autowired
	private SysMenuMapper sysMenuMapper;
	
	@Autowired
	private CommonMapper commonMapper;
	
	@Override
	public MenuTree getAllTreeMenu() {
		MenuTree menuTree = new MenuTree();
		menuTree.setId(0L);
		menuTree.setName("系统菜单");
		//1、查询当前节点的下级节点
		FillSubMenus(menuTree);
		return menuTree;
	}
	
	private void FillSubMenus(MenuTree menuTree){
		
		List<MenuTree> subMenuList = sysMenuMapper.findMenuByPid(menuTree.getId());
		for(MenuTree menu:subMenuList){
			FillSubMenus(menu);
			menuTree.getSubMenus().add(menu);
		}
	}

	@Override
	public Page<SysMenu> findMenuByPage(Page<SysMenu> page, MenuSearchVo menuSearchVo) {
		page.setRecords(sysMenuMapper.findMenuByPage(page, menuSearchVo));
	    return page;
	}

	@Override
	public SysMenu findMenuById(Long id) {
		return sysMenuMapper.selectById(id);
	}

	@Override
	public void saveDept(SysMenu sysMenu) {
		if(ToolUtil.isEmpty(sysMenu.getId())){
			sysMenu.setId(commonMapper.getSeq(SequenceConstants.SEQ_SYSMENU));
			sysMenuMapper.insert(sysMenu);
		}else{
			sysMenuMapper.updateById(sysMenu);
		}
	}

	@Override
	public List<SysMenu> findMenuBy(MenuSearchVo menuSearchVo) {
		return sysMenuMapper.findMenuBy(menuSearchVo);
	}

	@Override
	public void deleteByKey(long id) {
		sysMenuMapper.deleteById(id);
	}
}
