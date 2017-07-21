package cn.jack.codu.modules.druguse.service.impl;

import cn.jack.codu.modules.druguse.model.VDrugDict;
import cn.jack.codu.modules.druguse.model.vo.DrugInfoSearch;
import cn.jack.codu.modules.druguse.dao.VDrugDictMapper;
import cn.jack.codu.modules.druguse.service.IVDrugDictService;
import cn.jack.codu.modules.system.model.vo.SysUserVo;

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
 * @since 2017-07-14
 */
@Service
public class VDrugDictServiceImpl extends ServiceImpl<VDrugDictMapper, VDrugDict> implements IVDrugDictService {
	@Autowired
	private VDrugDictMapper vDrugDictMapper;
	
	@Override
	public Page<VDrugDict> findDrugByPage(Page<VDrugDict> page, DrugInfoSearch drugInfoSearch) {
		page.setRecords(vDrugDictMapper.findDrugByPage(page,drugInfoSearch));
        return page;
	}
}
