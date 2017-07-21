package cn.jack.codu.modules.druguse.service.impl;

import cn.jack.codu.modules.druguse.model.KzDrugSet;
import cn.jack.codu.modules.druguse.model.vo.DrugsetSearchVo;
import cn.jack.codu.modules.druguse.model.vo.DrugsetVo;
import cn.jack.codu.common.constants.SequenceConstants;
import cn.jack.codu.modules.druguse.dao.KzDrugSetMapper;
import cn.jack.codu.modules.druguse.service.IKzDrugSetService;
import cn.jack.codu.modules.system.dao.CommonMapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 药品使用量控制表 服务实现类
 * </p>
 *
 * @author Jackchen
 * @since 2017-07-09
 */
@Service
public class KzDrugSetServiceImpl extends ServiceImpl<KzDrugSetMapper, KzDrugSet> implements IKzDrugSetService {

	@Autowired
	private KzDrugSetMapper kzDrugSetMapper;
	
	@Autowired
	private CommonMapper commonMapper;
	
	@Override
	public Page<DrugsetVo> findDrugsetByPage(Page<DrugsetVo> page, DrugsetSearchVo drugsetSearchVo) {
		page.setRecords(kzDrugSetMapper.findDrugsetByPage(page,drugsetSearchVo));
		return page;
	}

	@Override
	public KzDrugSet findDrugSetById(long id) {
		return kzDrugSetMapper.selectById(id);
	}

	/**
	 * 保存药品控制设置
	 */
	@Override
	public boolean saveDrugSet(KzDrugSet kzDrugSet) {
		if(kzDrugSet.getSeq()==null){
			kzDrugSet.setSeq(commonMapper.getSeq(SequenceConstants.SEQ_KZDRUGSET));
			return kzDrugSetMapper.insert(kzDrugSet)>0;
		}else{
			return kzDrugSetMapper.updateById(kzDrugSet)>0;
		}
	}
	
}
