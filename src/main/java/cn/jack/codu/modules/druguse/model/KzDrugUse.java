package cn.jack.codu.modules.druguse.model;

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
@TableName("KZ_DRUG_USE")
public class KzDrugUse extends Model<KzDrugUse> {

    private static final long serialVersionUID = 1L;

    @TableId("SEQ")
	private Long seq;
	@TableField("USE_MOTH")
	private String useMoth;
	@TableField("USE_FLAG")
	private String useFlag;
	@TableField("SOURCE")
	private String source;
	@TableField("USE_UNIT")
	private String useUnit;
	@TableField("USE_TYPE")
	private String useType;
	@TableField("YPID")
	private String ypid;
	@TableField("USE_QUANTITY")
	private Double useQuantity;


	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public String getUseMoth() {
		return useMoth;
	}

	public void setUseMoth(String useMoth) {
		this.useMoth = useMoth;
	}

	public String getUseFlag() {
		return useFlag;
	}

	public void setUseFlag(String useFlag) {
		this.useFlag = useFlag;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getUseUnit() {
		return useUnit;
	}

	public void setUseUnit(String useUnit) {
		this.useUnit = useUnit;
	}

	public String getUseType() {
		return useType;
	}

	public void setUseType(String useType) {
		this.useType = useType;
	}

	public String getYpid() {
		return ypid;
	}

	public void setYpid(String ypid) {
		this.ypid = ypid;
	}

	public Double getUseQuantity() {
		return useQuantity;
	}

	public void setUseQuantity(Double useQuantity) {
		this.useQuantity = useQuantity;
	}

	@Override
	protected Serializable pkVal() {
		return this.seq;
	}

}
