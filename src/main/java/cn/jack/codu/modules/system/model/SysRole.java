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
@TableName("SYS_ROLE")
public class SysRole extends Model<SysRole> {

    private static final long serialVersionUID = 1L;

    @TableId("ID")
	private Long id;
	@TableField("ORDERSEQ")
	private Long orderseq;
	@TableField("STATUS")
	private Integer status;
	@TableField("ROLENAME")
	private String rolename;
	@TableField("DESCRIBLE")
	private String describle;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderseq() {
		return orderseq;
	}

	public void setOrderseq(Long orderseq) {
		this.orderseq = orderseq;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getDescrible() {
		return describle;
	}

	public void setDescrible(String describle) {
		this.describle = describle;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
