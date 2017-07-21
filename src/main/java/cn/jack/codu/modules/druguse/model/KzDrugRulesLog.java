package cn.jack.codu.modules.druguse.model;

import java.util.Date;
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
 * @since 2017-07-09
 */
@TableName("KZ_DRUG_RULES_LOG")
public class KzDrugRulesLog extends Model<KzDrugRulesLog> {

    private static final long serialVersionUID = 1L;

    @TableId("LOGID")
	private Long logid;
	@TableField("OUTDATA")
	private String outdata;
	@TableField("RESULT")
	private Integer result;
	@TableField("LOGDT")
	private Date logdt;
	@TableField("INDATA")
	private String indata;


	public Long getLogid() {
		return logid;
	}

	public void setLogid(Long logid) {
		this.logid = logid;
	}

	public String getOutdata() {
		return outdata;
	}

	public void setOutdata(String outdata) {
		this.outdata = outdata;
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public Date getLogdt() {
		return logdt;
	}

	public void setLogdt(Date logdt) {
		this.logdt = logdt;
	}

	public String getIndata() {
		return indata;
	}

	public void setIndata(String indata) {
		this.indata = indata;
	}

	@Override
	protected Serializable pkVal() {
		return this.logid;
	}

}
