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
@TableName("SYS_PARAM")
public class SysParam extends Model<SysParam> {

    private static final long serialVersionUID = 1L;

    @TableId("ID")
	private Long id;
	@TableField("NOTE")
	private String note;
	@TableField("PARMCDE")
	private String parmcde;
	@TableField("PARMVAL")
	private String parmval;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getParmcde() {
		return parmcde;
	}

	public void setParmcde(String parmcde) {
		this.parmcde = parmcde;
	}

	public String getParmval() {
		return parmval;
	}

	public void setParmval(String parmval) {
		this.parmval = parmval;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
