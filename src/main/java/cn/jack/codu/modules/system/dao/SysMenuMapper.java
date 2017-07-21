package cn.jack.codu.modules.system.dao;

import cn.jack.codu.modules.system.model.MenuTree;
import cn.jack.codu.modules.system.model.SysMenu;
import cn.jack.codu.modules.system.model.vo.MenuSearchVo;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author Jackchen
 * @since 2017-07-08
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

	List<MenuTree> findMenuByPid(Long id);

	List<SysMenu> findMenuByPage(Page<SysMenu> page, MenuSearchVo menuSearchVo);

	List<SysMenu> findMenuBy(MenuSearchVo menuSearchVo);

}