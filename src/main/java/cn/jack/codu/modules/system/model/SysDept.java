package cn.jack.codu.modules.system.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Jackchen
 * @since 2017-07-08
 */
@TableName("SYS_DEPT")
public class SysDept extends Model<SysDept> {

    private static final long serialVersionUID = 1L;

    @TableId("ID")
	private Long id;
	@TableField("PID")
	private Long pid;
	@TableField("ORDERSEQ")
	private Long orderseq;
	@TableField("DEPTNAME")
	private String deptname;
	@TableField("DEPTCODE")
	private String deptcode;
	@TableField("STATUS")
	private Integer status;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public Long getOrderseq() {
		return orderseq;
	}

	public void setOrderseq(Long orderseq) {
		this.orderseq = orderseq;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getDeptcode() {
		return deptcode;
	}

	public void setDeptcode(String deptcode) {
		this.deptcode = deptcode;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
