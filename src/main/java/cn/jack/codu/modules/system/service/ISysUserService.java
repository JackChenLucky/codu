package cn.jack.codu.modules.system.service;

import cn.jack.codu.modules.system.model.SysUser;
import cn.jack.codu.modules.system.model.vo.SysUserVo;
import cn.jack.codu.modules.system.model.vo.UserSearchVo;

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
public interface ISysUserService extends IService<SysUser> {

	SysUser findUserById(String id);

	void saveUser(SysUser sysuser);

	void deleteByKey(String uid);

	SysUser findUserByLoginName(String account);

	Page<SysUserVo> findUserByPage(Page<SysUserVo> page, UserSearchVo userSearchVo);

	boolean resetPassword(Long uid);

	
}
