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
@TableName("SYS_USER_RIGHT")
public class SysUserRight extends Model<SysUserRight> {

    private static final long serialVersionUID = 1L;

    @TableId("ID")
	private Long id;
	@TableField("RIGHTID")
	private Long rightid;
	@TableField("USERID")
	private Long userid;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRightid() {
		return rightid;
	}

	public void setRightid(Long rightid) {
		this.rightid = rightid;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
