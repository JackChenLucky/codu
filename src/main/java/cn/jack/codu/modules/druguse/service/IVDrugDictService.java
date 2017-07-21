package cn.jack.codu.modules.druguse.service;

import cn.jack.codu.modules.druguse.model.VDrugDict;
import cn.jack.codu.modules.druguse.model.vo.DrugInfoSearch;
import cn.jack.codu.modules.system.model.vo.SysUserVo;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Jackchen
 * @since 2017-07-14
 */
public interface IVDrugDictService extends IService<VDrugDict> {

	Page<VDrugDict> findDrugByPage(Page<VDrugDict> page, DrugInfoSearch drugInfoSearch);
	
}
