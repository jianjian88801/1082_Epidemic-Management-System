package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 密切接触者
 *
 * @author 
 * @email
 */
@TableName("miqiejiechuzhe")
public class MiqiejiechuzheEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public MiqiejiechuzheEntity() {

	}

	public MiqiejiechuzheEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 患者
     */
    @TableField(value = "huanzhe_id")

    private Integer huanzheId;


    /**
     * 密切接触者编号
     */
    @TableField(value = "miqiejiechuzhe_uuid_number")

    private String miqiejiechuzheUuidNumber;


    /**
     * 隔离地址
     */
    @TableField(value = "miqiejiechuzhe_geli_address")

    private String miqiejiechuzheGeliAddress;


    /**
     * 隔离类型
     */
    @TableField(value = "miqiejiechuzhe_geli_types")

    private Integer miqiejiechuzheGeliTypes;


    /**
     * 隔离备注
     */
    @TableField(value = "miqiejiechuzhe_content")

    private String miqiejiechuzheContent;


    /**
     * 隔离时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "geli_time")

    private Date geliTime;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：患者
	 */
    public Integer getHuanzheId() {
        return huanzheId;
    }
    /**
	 * 获取：患者
	 */

    public void setHuanzheId(Integer huanzheId) {
        this.huanzheId = huanzheId;
    }
    /**
	 * 设置：密切接触者编号
	 */
    public String getMiqiejiechuzheUuidNumber() {
        return miqiejiechuzheUuidNumber;
    }
    /**
	 * 获取：密切接触者编号
	 */

    public void setMiqiejiechuzheUuidNumber(String miqiejiechuzheUuidNumber) {
        this.miqiejiechuzheUuidNumber = miqiejiechuzheUuidNumber;
    }
    /**
	 * 设置：隔离地址
	 */
    public String getMiqiejiechuzheGeliAddress() {
        return miqiejiechuzheGeliAddress;
    }
    /**
	 * 获取：隔离地址
	 */

    public void setMiqiejiechuzheGeliAddress(String miqiejiechuzheGeliAddress) {
        this.miqiejiechuzheGeliAddress = miqiejiechuzheGeliAddress;
    }
    /**
	 * 设置：隔离类型
	 */
    public Integer getMiqiejiechuzheGeliTypes() {
        return miqiejiechuzheGeliTypes;
    }
    /**
	 * 获取：隔离类型
	 */

    public void setMiqiejiechuzheGeliTypes(Integer miqiejiechuzheGeliTypes) {
        this.miqiejiechuzheGeliTypes = miqiejiechuzheGeliTypes;
    }
    /**
	 * 设置：隔离备注
	 */
    public String getMiqiejiechuzheContent() {
        return miqiejiechuzheContent;
    }
    /**
	 * 获取：隔离备注
	 */

    public void setMiqiejiechuzheContent(String miqiejiechuzheContent) {
        this.miqiejiechuzheContent = miqiejiechuzheContent;
    }
    /**
	 * 设置：隔离时间
	 */
    public Date getGeliTime() {
        return geliTime;
    }
    /**
	 * 获取：隔离时间
	 */

    public void setGeliTime(Date geliTime) {
        this.geliTime = geliTime;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Miqiejiechuzhe{" +
            "id=" + id +
            ", huanzheId=" + huanzheId +
            ", miqiejiechuzheUuidNumber=" + miqiejiechuzheUuidNumber +
            ", miqiejiechuzheGeliAddress=" + miqiejiechuzheGeliAddress +
            ", miqiejiechuzheGeliTypes=" + miqiejiechuzheGeliTypes +
            ", miqiejiechuzheContent=" + miqiejiechuzheContent +
            ", geliTime=" + geliTime +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
