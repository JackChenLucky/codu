package cn.jack.codu.modules.druguse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.baomidou.mybatisplus.plugins.Page;

import cn.jack.codu.common.controller.BaseController;
import cn.jack.codu.modules.druguse.model.VDrugDict;
import cn.jack.codu.modules.druguse.model.vo.DrugInfoSearch;
import cn.jack.codu.modules.druguse.service.IVDrugDictService;
import cn.jack.codu.modules.system.model.vo.SysUserVo;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Jackchen
 * @since 2017-07-14
 */
@Controller
@RequestMapping("/drug")
public class VDrugDictController extends BaseController{
	
	@Autowired
	private IVDrugDictService vDrugDictService;
	
	@RequestMapping("/list")
	public ModelAndView list(DrugInfoSearch drugInfoSearch){
		ModelAndView view = new ModelAndView("druguse/druginfo/druginfo.html");
		Page page=new Page(drugInfoSearch.getPageNum(),drugInfoSearch.getNumPerPage());
		
		Page<VDrugDict> query = vDrugDictService.findDrugByPage(page,drugInfoSearch);
		view.addObject("totPage",page.getPages());
		view.addObject("totRow",page.getTotal());
		view.addObject("pageNumber",page.getSize());
		view.addObject("userList", page.getRecords());
		view.addObject("SearchCondition",drugInfoSearch);
		return view;
	}
}
