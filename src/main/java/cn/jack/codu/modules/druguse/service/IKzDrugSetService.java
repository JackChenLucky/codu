package cn.jack.codu.modules.druguse.service;

import cn.jack.codu.modules.druguse.model.KzDrugSet;
import cn.jack.codu.modules.druguse.model.vo.DrugsetSearchVo;
import cn.jack.codu.modules.druguse.model.vo.DrugsetVo;
import cn.jack.codu.modules.system.model.SysUser;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 药品使用量控制表 服务类
 * </p>
 *
 * @author Jackchen
 * @since 2017-07-09
 */
public interface IKzDrugSetService extends IService<KzDrugSet> {

	Page<DrugsetVo> findDrugsetByPage(Page<DrugsetVo> page, DrugsetSearchVo drugsetSearchVo);

	KzDrugSet findDrugSetById(long parseLong);

	boolean saveDrugSet(KzDrugSet kzDrugSet);
	
}
