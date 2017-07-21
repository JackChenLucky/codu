package cn.jack.codu.modules.druguse.model;

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
 * @since 2017-07-14
 */
@TableName("V_DRUG_DICT")
public class VDrugDict extends Model<VDrugDict> {

    private static final long serialVersionUID = 1L;

    /**
     * 包装单位
     */
	@TableField("BZDW")
	private String bzdw;
    /**
     * 规格
     */
	@TableField("GG")
	private String gg;
	@TableField("PYM")
	private String pym;
    /**
     * 最小包装数量
     */
	@TableField("ZXBZSL")
	private Double zxbzsl;
    /**
     * 单价
     */
	@TableField("DJ")
	private Double dj;
    /**
     * 最小包装单位
     */
	@TableField("ZXBZDW")
	private String zxbzdw;
    /**
     * 产地
     */
	@TableField("YPCD")
	private String ypcd;
    /**
     * 药品名称
     */
	@TableField("YPMC")
	private String ypmc;
	@TableField("YPCJ")
	private String ypcj;
	@TableField("JM")
	private String jm;
    /**
     * 药品序号
     */
	@TableField("YPXH")
	private String ypxh;
	@TableField("WBM")
	private String wbm;


	public String getBzdw() {
		return bzdw;
	}

	public void setBzdw(String bzdw) {
		this.bzdw = bzdw;
	}

	public String getGg() {
		return gg;
	}

	public void setGg(String gg) {
		this.gg = gg;
	}

	public String getPym() {
		return pym;
	}

	public void setPym(String pym) {
		this.pym = pym;
	}

	public Double getZxbzsl() {
		return zxbzsl;
	}

	public void setZxbzsl(Double zxbzsl) {
		this.zxbzsl = zxbzsl;
	}

	public Double getDj() {
		return dj;
	}

	public void setDj(Double dj) {
		this.dj = dj;
	}

	public String getZxbzdw() {
		return zxbzdw;
	}

	public void setZxbzdw(String zxbzdw) {
		this.zxbzdw = zxbzdw;
	}

	public String getYpcd() {
		return ypcd;
	}

	public void setYpcd(String ypcd) {
		this.ypcd = ypcd;
	}

	public String getYpmc() {
		return ypmc;
	}

	public void setYpmc(String ypmc) {
		this.ypmc = ypmc;
	}

	public String getYpcj() {
		return ypcj;
	}

	public void setYpcj(String ypcj) {
		this.ypcj = ypcj;
	}

	public String getJm() {
		return jm;
	}

	public void setJm(String jm) {
		this.jm = jm;
	}

	public String getYpxh() {
		return ypxh;
	}

	public void setYpxh(String ypxh) {
		this.ypxh = ypxh;
	}

	public String getWbm() {
		return wbm;
	}

	public void setWbm(String wbm) {
		this.wbm = wbm;
	}

	@Override
	protected Serializable pkVal() {
		return this.ypxh;
	}

}
