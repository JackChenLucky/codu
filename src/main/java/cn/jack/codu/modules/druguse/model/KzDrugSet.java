package cn.jack.codu.modules.druguse.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 药品使用量控制表
 * </p>
 *
 * @author Jackchen
 * @since 2017-07-09
 */
@TableName("KZ_DRUG_SET")
public class KzDrugSet extends Model<KzDrugSet> {

    private static final long serialVersionUID = 1L;

    /**
     * 序号
     */
    @TableId("SEQ")
	private Long seq;
    /**
     * 停用标志
     */
	@TableField("DC_FLAG")
	private String dcFlag;
    /**
     * 类别
     */
	@TableField("USE_TYPE")
	private String useType;
    /**
     * 门诊住院来源
     */
	@TableField("SOURCE")
	private String source;
    /**
     * 控制使用量
     */
	@TableField("USE_QUANTITY")
	private Double useQuantity;
    /**
     * 标志（当使用控制为科室时，当前为科室代码，当使用控制为个人时，当前为医生代码）
     */
	@TableField("USE_FLAG")
	private String useFlag;
    /**
     * 单位
     */
	@TableField("USE_UNIT")
	private String useUnit;
    /**
     * 药品序号
     */
	@TableField("YPXH")
	private String ypxh;
    /**
     * 控制级别
     */
	@TableField("KZ_LEVEL")
	private String kzLevel;


	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public String getDcFlag() {
		return dcFlag;
	}

	public void setDcFlag(String dcFlag) {
		this.dcFlag = dcFlag;
	}

	public String getUseType() {
		return useType;
	}

	public void setUseType(String useType) {
		this.useType = useType;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Double getUseQuantity() {
		return useQuantity;
	}

	public void setUseQuantity(Double useQuantity) {
		this.useQuantity = useQuantity;
	}

	public String getUseFlag() {
		return useFlag;
	}

	public void setUseFlag(String useFlag) {
		this.useFlag = useFlag;
	}

	public String getUseUnit() {
		return useUnit;
	}

	public void setUseUnit(String useUnit) {
		this.useUnit = useUnit;
	}

	public String getYpxh() {
		return ypxh;
	}

	public void setYpxh(String ypxh) {
		this.ypxh = ypxh;
	}

	public String getKzLevel() {
		return kzLevel;
	}

	public void setKzLevel(String kzLevel) {
		this.kzLevel = kzLevel;
	}

	@Override
	protected Serializable pkVal() {
		return this.seq;
	}

}
