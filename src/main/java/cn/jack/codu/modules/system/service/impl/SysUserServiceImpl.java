package cn.jack.codu.modules.system.service.impl;

import cn.jack.codu.modules.system.model.SysUser;
import cn.jack.codu.modules.system.model.vo.SysUserVo;
import cn.jack.codu.modules.system.model.vo.UserSearchVo;
import cn.jack.codu.common.constants.PublicConstants;
import cn.jack.codu.common.constants.SequenceConstants;
import cn.jack.codu.core.shiro.ShiroKit;
import cn.jack.codu.modules.system.dao.CommonMapper;
import cn.jack.codu.modules.system.dao.SysUserMapper;
import cn.jack.codu.modules.system.service.ISysUserService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

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
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Autowired
	private CommonMapper commonMapper;
	
	@Override
	public SysUser findUserByLoginName(String account) {
		SysUser user = new SysUser();
		user.setLoginname(account);
		return super.selectOne(new EntityWrapper<SysUser>(user));
	}

	@Override
	public SysUser findUserById(String id) {
		return sysUserMapper.selectById(id);
	}

	@Override
	public void saveUser(SysUser sysuser) {
		if(sysuser.getId()==null){	
			sysuser.setId(commonMapper.getSeq(SequenceConstants.SEQ_SYSUSER));
			sysUserMapper.insert(sysuser);
		}else{			
			sysUserMapper.updateById(sysuser);
		}
	}

	@Override
	public Page<SysUserVo> findUserByPage(Page<SysUserVo> page,UserSearchVo userSearchVo) {
		page.setRecords(sysUserMapper.findUserByPage(page,userSearchVo));
        return page;
	}

	@Override
	public void deleteByKey(Long id) {
		sysUserMapper.deleteById(id);
	}
	
	/**
	 *重置用户的密码 为1
	 */
	@Override
	public boolean resetPassword(Long uid) {
		SysUser user = new SysUser();
		user.setId(uid);
		user.setPassword(ShiroKit.md5("1", PublicConstants.MD5SALT));
		return sysUserMapper.updateById(user)>0;
	}
	
}
