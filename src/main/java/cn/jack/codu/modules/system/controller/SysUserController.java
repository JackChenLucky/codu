package cn.jack.codu.modules.system.controller;

import java.sql.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baomidou.mybatisplus.plugins.Page;

import cn.jack.codu.common.constants.DwzConstants;
import cn.jack.codu.common.controller.BaseController;
import cn.jack.codu.common.model.AjaxResult;
import cn.jack.codu.common.model.DwzResult;
import cn.jack.codu.core.util.ContextHolder;
import cn.jack.codu.modules.system.model.SysUser;
import cn.jack.codu.modules.system.model.vo.SysUserVo;
import cn.jack.codu.modules.system.model.vo.UserSearchVo;
import cn.jack.codu.modules.system.service.ISysUserService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Jackchen
 * @since 2017-07-07
 */
@Controller
@RequestMapping("/user")
public class SysUserController extends BaseController{
	
	@Autowired
	private ISysUserService sysUserService;
	
	/**
	 * 用户列表页，附带用户查询条件
	 * @param userSearchVo
	 * @return
	 */
	@RequestMapping("/view")
	public ModelAndView view(UserSearchVo userSearchVo){
		Page page=new Page(userSearchVo.getPageNum(),userSearchVo.getNumPerPage());
		ModelAndView view = new ModelAndView("system/user/user_view.html");
		Page<SysUserVo> query = sysUserService.findUserByPage(page,userSearchVo);
		view.addObject("totPage",query.getPages());
		view.addObject("totRow",query.getTotal());
		view.addObject("pageNumber",query.getSize());
		view.addObject("userList", query.getRecords());
		view.addObject("SearchCondition",userSearchVo);
		return view;
	}
	
	@RequestMapping("/edit")
	public ModelAndView edit(String id){
		ModelAndView view = new ModelAndView("system/user/user_edit.html");
		if(StringUtils.isNotBlank(id)){
			SysUser user = sysUserService.findUserById(id);
			view.addObject("deptname",ContextHolder.self().getDeptName(user.getDept()));
			view.addObject("user", user);
		}
		return view;
	}
	
	
	@RequestMapping("/save")
	public @ResponseBody DwzResult save(SysUserVo puser){
		if(StringUtils.isNotBlank(puser.getBirthday_str())){
			puser.setBirthday(Date.valueOf(puser.getBirthday_str()));
		}
		
		if(StringUtils.isNotBlank(puser.getExpiredate_str())){
			puser.setExpiredate(Date.valueOf(puser.getExpiredate_str()));
		}
		SysUser sysuser = new SysUser();
		BeanUtils.copyProperties(puser, sysuser);
		sysUserService.saveUser(sysuser);
		DwzResult result = new DwzResult();
		result.setStatusCode(DwzConstants.DWZ_STATUS_OK);
		result.setCallbackType(DwzConstants.DWZ_CALLBACKTYPE_CLOSECURRENT);
		return result;
	}
	/**
	 * 删除指定的用户，（不做物理删除，直接作废）
	 * @param uid
	 * @return
	 */
	@RequestMapping("/delete/{uid}")
	public @ResponseBody AjaxResult delete(@PathVariable String uid){
		AjaxResult result = new AjaxResult();
		sysUserService.deleteByKey(Long.parseLong(uid));
		return result;
	}
	
	/**
	 * 修改用户状态为停用
	 * @param uid
	 * @return
	 */
	@RequestMapping("/disable/{uid}")
	public @ResponseBody AjaxResult disable(@PathVariable String uid){
		AjaxResult result = new AjaxResult();
		SysUser user = sysUserService.findUserById(uid);
		user.setStatus(1);//作废
		sysUserService.saveUser(user);
		return result;
	}
	
	@RequestMapping("/enable/{uid}")
	public @ResponseBody AjaxResult enable(@PathVariable String uid){
		AjaxResult result = new AjaxResult();
		SysUser user = sysUserService.findUserById(uid);
		user.setStatus(0);//作废
		sysUserService.saveUser(user);
		return result;
	}
	
	@RequestMapping("/resetpwd/{uid}")
	public @ResponseBody AjaxResult resetPassword(@PathVariable String uid){
		AjaxResult result = new AjaxResult();
		boolean res = sysUserService.resetPassword(Long.parseLong(uid));
		result.setCode(res?0:1);
		return result;
	} 
}
