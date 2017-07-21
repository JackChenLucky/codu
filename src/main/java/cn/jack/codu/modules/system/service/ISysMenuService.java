package cn.jack.codu.modules.system.service;

import cn.jack.codu.modules.system.model.MenuTree;
import cn.jack.codu.modules.system.model.SysMenu;
import cn.jack.codu.modules.system.model.vo.MenuSearchVo;

import java.util.List;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Jackchen
 * @since 2017-07-08
 */
public interface ISysMenuService extends IService<SysMenu> {

	MenuTree getAllTreeMenu();

	Page<SysMenu> findMenuByPage(Page<SysMenu> page, MenuSearchVo menuSearchVo);

	SysMenu findMenuById(Long id);

	void saveDept(SysMenu sysMenu);

	List<SysMenu> findMenuBy(MenuSearchVo menuSearchVo);

	void deleteByKey(long parseLong);
	
}
