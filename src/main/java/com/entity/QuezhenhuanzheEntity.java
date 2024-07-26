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
 * 确诊患者
 *
 * @author 
 * @email
 */
@TableName("quezhenhuanzhe")
public class QuezhenhuanzheEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public QuezhenhuanzheEntity() {

	}

	public QuezhenhuanzheEntity(T t) {
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
     * 确诊患者编号
     */
    @TableField(value = "quezhenhuanzhe_uuid_number")

    private String quezhenhuanzheUuidNumber;


    /**
     * 确诊位置
     */
    @TableField(value = "quezhenhuanzhe_geli_address")

    private String quezhenhuanzheGeliAddress;


    /**
     * 确诊备注
     */
    @TableField(value = "quezhenhuanzhe_content")

    private String quezhenhuanzheContent;


    /**
     * 确诊时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "quezhen_time")

    private Date quezhenTime;


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
	 * 设置：确诊患者编号
	 */
    public String getQuezhenhuanzheUuidNumber() {
        return quezhenhuanzheUuidNumber;
    }
    /**
	 * 获取：确诊患者编号
	 */

    public void setQuezhenhuanzheUuidNumber(String quezhenhuanzheUuidNumber) {
        this.quezhenhuanzheUuidNumber = quezhenhuanzheUuidNumber;
    }
    /**
	 * 设置：确诊位置
	 */
    public String getQuezhenhuanzheGeliAddress() {
        return quezhenhuanzheGeliAddress;
    }
    /**
	 * 获取：确诊位置
	 */

    public void setQuezhenhuanzheGeliAddress(String quezhenhuanzheGeliAddress) {
        this.quezhenhuanzheGeliAddress = quezhenhuanzheGeliAddress;
    }
    /**
	 * 设置：确诊备注
	 */
    public String getQuezhenhuanzheContent() {
        return quezhenhuanzheContent;
    }
    /**
	 * 获取：确诊备注
	 */

    public void setQuezhenhuanzheContent(String quezhenhuanzheContent) {
        this.quezhenhuanzheContent = quezhenhuanzheContent;
    }
    /**
	 * 设置：确诊时间
	 */
    public Date getQuezhenTime() {
        return quezhenTime;
    }
    /**
	 * 获取：确诊时间
	 */

    public void setQuezhenTime(Date quezhenTime) {
        this.quezhenTime = quezhenTime;
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
        return "Quezhenhuanzhe{" +
            "id=" + id +
            ", huanzheId=" + huanzheId +
            ", quezhenhuanzheUuidNumber=" + quezhenhuanzheUuidNumber +
            ", quezhenhuanzheGeliAddress=" + quezhenhuanzheGeliAddress +
            ", quezhenhuanzheContent=" + quezhenhuanzheContent +
            ", quezhenTime=" + quezhenTime +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
