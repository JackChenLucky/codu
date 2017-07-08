package cn.jack.codu.modules.instructions.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.jack.codu.common.controller.BaseController;

/**
 * 批示件
 * @author JackChen
 *
 */
@Controller
@RequestMapping("/item")
public class ItemController extends BaseController {
	
	@RequestMapping("/view.htm")
	public ModelAndView view(){
		ModelAndView view = new ModelAndView("instructions/item/item_view.html");
		
		return view;
	}
	
	@RequestMapping("/edit.htm")
	public ModelAndView edit(){
		ModelAndView view = new ModelAndView("instructions/item/item_edit.html");
		return view;
	}
}
