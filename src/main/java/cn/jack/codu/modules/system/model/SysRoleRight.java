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
@TableName("SYS_ROLE_RIGHT")
public class SysRoleRight extends Model<SysRoleRight> {

    private static final long serialVersionUID = 1L;

    @TableId("ID")
	private Long id;
	@TableField("MENUID")
	private Long menuid;
	@TableField("ROLEID")
	private Long roleid;
	@TableField("FUNCID")
	private Long funcid;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMenuid() {
		return menuid;
	}

	public void setMenuid(Long menuid) {
		this.menuid = menuid;
	}

	public Long getRoleid() {
		return roleid;
	}

	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}

	public Long getFuncid() {
		return funcid;
	}

	public void setFuncid(Long funcid) {
		this.funcid = funcid;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
