package cn.jack.codu.modules.druguse.dao;

import cn.jack.codu.modules.druguse.model.KzDrugSet;
import cn.jack.codu.modules.druguse.model.vo.DrugsetSearchVo;
import cn.jack.codu.modules.druguse.model.vo.DrugsetVo;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
  * 药品使用量控制表 Mapper 接口
 * </p>
 *
 * @author Jackchen
 * @since 2017-07-09
 */
public interface KzDrugSetMapper extends BaseMapper<KzDrugSet> {

	List<DrugsetVo> findDrugsetByPage(Page<DrugsetVo> page, DrugsetSearchVo drugsetSearchVo);

}