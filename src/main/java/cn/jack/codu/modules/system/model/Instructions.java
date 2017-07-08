package cn.jack.codu.modules.system.model;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Jackchen
 * @since 2017-07-07
 */
public class Instructions extends Model<Instructions> {

    private static final long serialVersionUID = 1L;

	private Integer id;
    /**
     * 项目名称
     */
	private String itemname;
    /**
     * 申请日期
     */
	private Date requestdt;
    /**
     * 申请人
     */
	private String requestuser;
    /**
     * 牵头单位
     */
	private String leaddept;
    /**
     * 责任单位
     */
	private String dutydept;
	private String dutyuser;
	private String complexity;
    /**
     * 进度
     */
	private String progress;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public Date getRequestdt() {
		return requestdt;
	}

	public void setRequestdt(Date requestdt) {
		this.requestdt = requestdt;
	}

	public String getRequestuser() {
		return requestuser;
	}

	public void setRequestuser(String requestuser) {
		this.requestuser = requestuser;
	}

	public String getLeaddept() {
		return leaddept;
	}

	public void setLeaddept(String leaddept) {
		this.leaddept = leaddept;
	}

	public String getDutydept() {
		return dutydept;
	}

	public void setDutydept(String dutydept) {
		this.dutydept = dutydept;
	}

	public String getDutyuser() {
		return dutyuser;
	}

	public void setDutyuser(String dutyuser) {
		this.dutyuser = dutyuser;
	}

	public String getComplexity() {
		return complexity;
	}

	public void setComplexity(String complexity) {
		this.complexity = complexity;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
