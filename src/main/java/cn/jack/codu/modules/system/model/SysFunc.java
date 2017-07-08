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
@TableName("SYS_FUNC")
public class SysFunc extends Model<SysFunc> {

    private static final long serialVersionUID = 1L;

    @TableId("ID")
	private Long id;
	@TableField("FUNCNAME")
	private String funcname;
	@TableField("FUNCTYPE")
	private String functype;
	@TableField("MENUID")
	private Long menuid;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFuncname() {
		return funcname;
	}

	public void setFuncname(String funcname) {
		this.funcname = funcname;
	}

	public String getFunctype() {
		return functype;
	}

	public void setFunctype(String functype) {
		this.functype = functype;
	}

	public Long getMenuid() {
		return menuid;
	}

	public void setMenuid(Long menuid) {
		this.menuid = menuid;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
