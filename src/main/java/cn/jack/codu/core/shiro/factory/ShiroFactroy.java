package cn.jack.codu.core.shiro.factory;

import org.apache.shiro.authc.CredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sun.tools.javac.util.Convert;

import cn.jack.codu.common.constants.UserStatus;
import cn.jack.codu.core.shiro.ShiroUser;
import cn.jack.codu.core.util.SpringContextHolder;
import cn.jack.codu.modules.system.model.SysUser;
import cn.jack.codu.modules.system.service.ISysMenuService;
import cn.jack.codu.modules.system.service.ISysUserService;

import java.util.ArrayList;
import java.util.List;

@Service
@DependsOn("springContextHolder")
@Transactional(readOnly = true)
public class ShiroFactroy implements IShiro {

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private ISysMenuService sysMenuService;

    public static IShiro me() {
        return SpringContextHolder.getBean(IShiro.class);
    }

    @Override
    public SysUser user(String account) {

        SysUser user = sysUserService.findUserByLoginName(account);

        // 账号不存在
        if (null == user) {
            throw new CredentialsException();
        }
        // 账号被冻结
        if (user.getStatus() != UserStatus.OK.getCode()) {
            throw new LockedAccountException();
        }
        return user;
    }

    @Override
    public ShiroUser shiroUser(SysUser user) {
        ShiroUser shiroUser = new ShiroUser();

        shiroUser.setId(user.getId());            // 账号id
        shiroUser.setAccount(user.getLoginname());// 账号
//        shiroUser.setDeptId(user.getDept());    // 部门id
//        shiroUser.setDeptName(ConstantFactory.me().getDeptName(user.getDeptid()));// 部门名称
//        shiroUser.setName(user.getUsername());        // 用户名称
//
//        Integer[] roleArray = Convert.toIntArray(user.getRoleid());// 角色集合
//        List<Integer> roleList = new ArrayList<Integer>();
//        List<String> roleNameList = new ArrayList<String>();
//        for (int roleId : roleArray) {
//            roleList.add(roleId);
//            roleNameList.add(ConstantFactory.me().getSingleRoleName(roleId));
//        }
//        shiroUser.setRoleList(roleList);
//        shiroUser.setRoleNames(roleNameList);

        return shiroUser;
    }

    @Override
    public List<String> findPermissionsByRoleId(Integer roleId) {
        List<String> resUrls = null;
        //menuDao.getResUrlsByRoleId(roleId);
        return resUrls;
    }

    @Override
    public String findRoleNameByRoleId(Integer roleId) {
        return null;//ConstantFactory.me().getSingleRoleTip(roleId);
    }

    @Override
    public SimpleAuthenticationInfo info(ShiroUser shiroUser, SysUser user, String realmName) {
        String credentials = user.getPassword();
        // 密码加盐处理
        String source = "jackchen";
        ByteSource credentialsSalt = new Md5Hash(source);
        
        
        return new SimpleAuthenticationInfo(shiroUser, credentials, credentialsSalt, realmName);
    }

}
