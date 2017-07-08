package cn.jack.codu.modules.system.controller;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.jack.codu.common.controller.BaseController;
import cn.jack.codu.common.model.AjaxResult;
import cn.jack.codu.core.shiro.ShiroKit;
import cn.jack.codu.core.shiro.ShiroUser;
import cn.jack.codu.modules.system.model.vo.LoginVo;
import cn.jack.codu.modules.system.service.ISysMenuService;

@Controller
public class IndexController extends BaseController{
	
	@Autowired
	private ISysMenuService sysMenuService;
	
	 /**
     * 跳转到登录页面
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        if (ShiroKit.isAuthenticated() || ShiroKit.getUser() != null) {
        	logger.info("---跳转到首页-");
            return REDIRECT + "/index";
        } else {
        	logger.info("---跳转到登录页----");
            return "/login.html";
        }
    }
    
    @RequestMapping("/ajaxLogin")
    public @ResponseBody AjaxResult ajaxLogin(LoginVo loginVo){
    	AjaxResult result = new AjaxResult();
        Subject currentUser = ShiroKit.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginVo.getUsername(), loginVo.getPassword().toCharArray());
        token.setRememberMe(true);
        try{
        	currentUser.login(token);
        } catch (UnknownAccountException uae) {
        	result.addFail("用户名不存在！");
            logger.info("用户名不存在"); 
        } catch (IncorrectCredentialsException ice) {
        	result.addFail("密码错误！");
        	logger.info("password didn't match."); 
        } catch (LockedAccountException lae) {
        	result.addFail("账户被锁定");
        	logger.info("account for that username is locked - can't login."); 
        } catch (AuthenticationException ae) {
        	result.addFail("用户名密码校验失败！"+ae.getMessage());
        	logger.info("unexpected condition."); 
        }
        ShiroUser shiroUser = ShiroKit.getUser();
        super.getSession().setAttribute("shiroUser", shiroUser);
    	return result;
    }
    
    /**
     * 跳转到主页
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {
    	model.addAttribute("menuTree", sysMenuService.getAllTreeMenu());
        return "/index.html";
    }
	
	@RequestMapping(path="/logout",method=RequestMethod.GET)
	public String logout(){
		Subject currentUser = ShiroKit.getSubject();
		currentUser.logout();
		super.getSession().invalidate();
        return REDIRECT + "/login";
	}
}
