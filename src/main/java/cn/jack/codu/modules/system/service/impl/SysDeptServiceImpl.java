package cn.jack.codu.modules.system.service.impl;

import cn.jack.codu.modules.system.model.DeptTree;
import cn.jack.codu.modules.system.model.SysDept;
import cn.jack.codu.modules.system.model.vo.DeptSearchVo;
import cn.jack.codu.modules.system.model.vo.SysDeptVo;
import cn.jack.codu.modules.system.dao.SysDeptMapper;
import cn.jack.codu.modules.system.service.ISysDeptService;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jackchen
 * @since 2017-07-08
 */
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements ISysDeptService {

	@Autowired
	private SysDeptMapper sysDeptMapper;
	
	@Override
	public Page<SysDeptVo> findDeptByPage(Page<SysDeptVo> page, DeptSearchVo deptSearchVo) {
		page.setRecords(sysDeptMapper.findDeptByPage(page,deptSearchVo));
        return page;
	}
	
	/**
	 * 获取树形结构部门列表
	 */
	@Override
	public DeptTree getAllTreeDept() {
		DeptTree deptTree = new DeptTree();
		deptTree.setId(0L);
		deptTree.setDeptname("组织机构");
		//1、查询当前节点的下级节点
		FillSubDepts(deptTree);
		return deptTree;
	}
	
	private void FillSubDepts(DeptTree deptTree){
		List<DeptTree> subDeptList = sysDeptMapper.findDeptByPid(deptTree.getId());
		for(DeptTree dept:subDeptList){
			FillSubDepts(dept);
			deptTree.getSubDepts().add(dept);
		}
	}

	@Override
	public void saveDept(SysDept sysdept) {
		
		
	}

	/**
	 * 根据主键查询病区信息
	 */
	@Override
	public SysDept findDeptById(Long id) {
		return sysDeptMapper.selectById(id);
	}
	
}
