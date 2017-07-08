package cn.jack.codu.modules.system.dao;

import cn.jack.codu.modules.system.model.MenuTree;
import cn.jack.codu.modules.system.model.SysMenu;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;

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

}