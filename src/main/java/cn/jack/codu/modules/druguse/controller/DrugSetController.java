package cn.jack.codu.modules.druguse.controller;

import java.sql.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baomidou.mybatisplus.plugins.Page;

import cn.jack.codu.common.constants.DwzConstants;
import cn.jack.codu.common.controller.BaseController;
import cn.jack.codu.common.model.DwzResult;
import cn.jack.codu.core.util.ContextHolder;
import cn.jack.codu.modules.druguse.model.KzDrugSet;
import cn.jack.codu.modules.druguse.model.vo.DrugsetSearchVo;
import cn.jack.codu.modules.druguse.model.vo.DrugsetVo;
import cn.jack.codu.modules.druguse.service.IKzDrugSetService;
import cn.jack.codu.modules.system.model.SysUser;
import cn.jack.codu.modules.system.model.vo.SysUserVo;

/**
 * 药品控制使用量维护控制层
 * @author JackChen
 *
 */
@Controller
@RequestMapping("/drugset")
public class DrugSetController extends BaseController {

	@Autowired
	private IKzDrugSetService kzDrugSetService;
	
	@RequestMapping("/view")
	public ModelAndView view(DrugsetSearchVo drugsetSearchVo){
		ModelAndView view = new ModelAndView("druguse/drugset/drugset_view.html");
		Page<DrugsetVo> page=new Page<DrugsetVo>(drugsetSearchVo.getPageNum(),drugsetSearchVo.getNumPerPage());
		Page<DrugsetVo> query = kzDrugSetService.findDrugsetByPage(page,drugsetSearchVo);
		view.addObject("totPage",query.getPages());
		view.addObject("totRow",query.getTotal());
		view.addObject("pageNumber",query.getSize());
		view.addObject("drugList", query.getRecords());
		view.addObject("SearchCondition",drugsetSearchVo);
		
		return view;
	}
	
	@RequestMapping("/edit")
	public ModelAndView edit(String id){
		ModelAndView view = new ModelAndView("druguse/drugset/drugset_edit.html");
		if(StringUtils.isNotBlank(id)){
			KzDrugSet kzDrugSet = kzDrugSetService.findDrugSetById(Long.parseLong(id));
//			view.addObject("deptname",ContextHolder.self().getDeptName(user.getDept()));
			view.addObject("drugset", kzDrugSet);
		}
		return view;
	}
	
	@RequestMapping("/save")
	public @ResponseBody DwzResult save(KzDrugSet kzDrugSet){
		
		kzDrugSetService.saveDrugSet(kzDrugSet);
		DwzResult result = new DwzResult();
		result.setStatusCode(DwzConstants.DWZ_STATUS_OK);
		result.setCallbackType(DwzConstants.DWZ_CALLBACKTYPE_CLOSECURRENT);
		return result;
	}
}
