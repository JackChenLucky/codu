package cn.jack.codu.modules.system.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baomidou.mybatisplus.plugins.Page;

import cn.jack.codu.common.constants.DwzConstants;
import cn.jack.codu.common.model.AjaxResult;
import cn.jack.codu.common.model.DwzResult;
import cn.jack.codu.modules.system.model.MenuTree;
import cn.jack.codu.modules.system.model.SysMenu;
import cn.jack.codu.modules.system.model.vo.MenuSearchVo;
import cn.jack.codu.modules.system.model.vo.SysMenuVo;
import cn.jack.codu.modules.system.service.ISysMenuService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Jackchen
 * @since 2017-07-07
 */
@Controller
@RequestMapping("/menu")
public class SysMenuController {

	@Autowired
	private ISysMenuService sysMenuService;
	
	@RequestMapping("/view")
	public ModelAndView view(MenuSearchVo menuSearchVo){
		ModelAndView view = new ModelAndView("system/menu/menu_view.html");
		List<SysMenu> menus = sysMenuService.findMenuBy(menuSearchVo);
		view.addObject("menuList", menus);
		view.addObject("SearchCondition",menuSearchVo);
		MenuTree menu = sysMenuService.getAllTreeMenu();
		view.addObject("menuHtml", "<ul class=\"tree treeFolder expand\">"+getMenuHtml(menu)+"</ul>");
		return view;
	}
	
	private String getMenuHtml(MenuTree menuTree){
		StringBuffer sb = new StringBuffer();
		if(menuTree.getSubMenus().size()>0){
			sb.append("<li><a href=\"javascript:\" onclick=\"showMenuDtl({id:'").append(menuTree.getId()).append("', menuName:'").append(menuTree.getName()).append("'})\">").append(menuTree.getName()).append("</a>");
			sb.append("<ul>");
			for(MenuTree menu:menuTree.getSubMenus()){
				sb.append(getMenuHtml(menu));
			}
			sb.append("</ul></li>");
		}else{
			sb.append("<li><a href=\"javascript:\" onclick=\"showMenuDtl({id:'").append(menuTree.getId()).append("', menuName:'").append(menuTree.getName()).append("'})\">").append(menuTree.getName()).append("</a></li>");
		}
		return sb.toString();
	}
	
	
	@RequestMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable String id){
		ModelAndView view = new ModelAndView("system/menu/menu_edit.html");
		if(StringUtils.isNotBlank(id)){
			SysMenu menu = sysMenuService.findMenuById(Long.parseLong(id));
			view.addObject("menu", menu);
			if(menu.getPid()!=0){
				SysMenu pMenu = sysMenuService.findMenuById(menu.getPid());
				if(pMenu!=null){
					view.addObject("pmenuname",pMenu.getName());
				}
			}else{
				view.addObject("pmenuname","系统菜单");
			}
		}
		return view;
	}
	
	@RequestMapping("/lookup/{id}")
	public ModelAndView lookup(@PathVariable String id){
		ModelAndView view = new ModelAndView("system/menu/menu_lookup.html");
		MenuTree menu = sysMenuService.getAllTreeMenu();
		view.addObject("menuHtml", "<ul class=\"tree treeFolder expand\">"+getMenuBringBackHtml(menu)+"</ul>");
		return view;
	}
	
	private String getMenuBringBackHtml(MenuTree menuTree){
		StringBuffer sb = new StringBuffer();
		if(menuTree.getSubMenus().size()>0){
			sb.append("<li><a href=\"javascript:\" onclick=\"$.bringBack({id:'").append(menuTree.getId()).append("', menuName:'").append(menuTree.getName()).append("'})\">").append(menuTree.getName()).append("</a>");
			sb.append("<ul>");
			for(MenuTree menu:menuTree.getSubMenus()){
				sb.append(getMenuBringBackHtml(menu));
			}
			sb.append("</ul></li>");
		}else{
			sb.append("<li><a href=\"javascript:\" onclick=\"$.bringBack({id:'").append(menuTree.getId()).append("', menuName:'").append(menuTree.getName()).append("'})\">").append(menuTree.getName()).append("</a></li>");
		}
		return sb.toString();
	}
	
	@RequestMapping("/delete/{id}")
	public @ResponseBody AjaxResult delete(@PathVariable String id){
		AjaxResult result = new AjaxResult();
		sysMenuService.deleteByKey(Long.parseLong(id));
		return result;
	}
	
	@RequestMapping("/save")
	public @ResponseBody DwzResult save(SysMenuVo sysMenuVo){
		SysMenu sysMenu = new SysMenu();
		BeanUtils.copyProperties(sysMenuVo, sysMenu);
		sysMenuService.saveDept(sysMenu);
		DwzResult result = new DwzResult();
		result.setStatusCode(DwzConstants.DWZ_STATUS_OK);
		result.setCallbackType(DwzConstants.DWZ_CALLBACKTYPE_CLOSECURRENT);
		return result;
	}
}
