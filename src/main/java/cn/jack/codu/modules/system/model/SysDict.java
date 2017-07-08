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
@TableName("SYS_DICT")
public class SysDict extends Model<SysDict> {

    private static final long serialVersionUID = 1L;

    @TableId("ID")
	private Long id;
	@TableField("DICTVAL")
	private String dictval;
	@TableField("DICTTYPE")
	private String dicttype;
	@TableField("DICTORDER")
	private Long dictorder;
	@TableField("STATUS")
	private Integer status;
	@TableField("DFLTVAL")
	private String dfltval;
	@TableField("DICTCDE")
	private String dictcde;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDictval() {
		return dictval;
	}

	public void setDictval(String dictval) {
		this.dictval = dictval;
	}

	public String getDicttype() {
		return dicttype;
	}

	public void setDicttype(String dicttype) {
		this.dicttype = dicttype;
	}

	public Long getDictorder() {
		return dictorder;
	}

	public void setDictorder(Long dictorder) {
		this.dictorder = dictorder;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDfltval() {
		return dfltval;
	}

	public void setDfltval(String dfltval) {
		this.dfltval = dfltval;
	}

	public String getDictcde() {
		return dictcde;
	}

	public void setDictcde(String dictcde) {
		this.dictcde = dictcde;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
