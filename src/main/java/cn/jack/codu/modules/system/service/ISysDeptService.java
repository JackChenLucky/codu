package cn.jack.codu.modules.system.service;

import cn.jack.codu.modules.system.model.DeptTree;
import cn.jack.codu.modules.system.model.SysDept;
import cn.jack.codu.modules.system.model.vo.DeptSearchVo;
import cn.jack.codu.modules.system.model.vo.SysDeptVo;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Jackchen
 * @since 2017-07-08
 */
public interface ISysDeptService extends IService<SysDept> {

	DeptTree getAllTreeDept();

	Page<SysDeptVo> findDeptByPage(Page<SysDeptVo> page, DeptSearchVo deptSearchVo);

	SysDept findDeptById(Long pid);

	void saveDept(SysDept sysdept);
	
}
