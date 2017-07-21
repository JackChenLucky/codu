package cn.jack.codu.modules.druguse.dao;

import cn.jack.codu.modules.druguse.model.VDrugDict;
import cn.jack.codu.modules.druguse.model.vo.DrugInfoSearch;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author Jackchen
 * @since 2017-07-14
 */
public interface VDrugDictMapper extends BaseMapper<VDrugDict> {

	List<VDrugDict> findDrugByPage(Page<VDrugDict> page, DrugInfoSearch drugInfoSearch);

}