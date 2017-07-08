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
@TableName("SYS_DICTTYPE")
public class SysDicttype extends Model<SysDicttype> {

    private static final long serialVersionUID = 1L;

    @TableId("ID")
	private Long id;
	@TableField("STATUS")
	private Integer status;
	@TableField("NOTE")
	private String note;
	@TableField("DICTTYPE")
	private String dicttype;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getDicttype() {
		return dicttype;
	}

	public void setDicttype(String dicttype) {
		this.dicttype = dicttype;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
