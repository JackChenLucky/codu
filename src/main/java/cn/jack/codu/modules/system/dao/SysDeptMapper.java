package cn.jack.codu.modules.system.dao;

import cn.jack.codu.modules.system.model.DeptTree;
import cn.jack.codu.modules.system.model.SysDept;
import cn.jack.codu.modules.system.model.vo.DeptSearchVo;
import cn.jack.codu.modules.system.model.vo.SysDeptVo;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author Jackchen
 * @since 2017-07-08
 */
public interface SysDeptMapper extends BaseMapper<SysDept> {

	List<SysDeptVo> findDeptByPage(Page<SysDeptVo> page, DeptSearchVo deptSearchVo);

	List<DeptTree> findDeptByPid(Long pid);

	SysDept selectByCode(String deptCode);

}