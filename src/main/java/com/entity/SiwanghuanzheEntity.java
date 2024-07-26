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
 * 死亡患者
 *
 * @author 
 * @email
 */
@TableName("siwanghuanzhe")
public class SiwanghuanzheEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public SiwanghuanzheEntity() {

	}

	public SiwanghuanzheEntity(T t) {
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
     * 死亡患者编号
     */
    @TableField(value = "siwanghuanzhe_uuid_number")

    private String siwanghuanzheUuidNumber;


    /**
     * 死亡备注
     */
    @TableField(value = "siwanghuanzhe_content")

    private String siwanghuanzheContent;


    /**
     * 死亡时间
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
	 * 设置：死亡患者编号
	 */
    public String getSiwanghuanzheUuidNumber() {
        return siwanghuanzheUuidNumber;
    }
    /**
	 * 获取：死亡患者编号
	 */

    public void setSiwanghuanzheUuidNumber(String siwanghuanzheUuidNumber) {
        this.siwanghuanzheUuidNumber = siwanghuanzheUuidNumber;
    }
    /**
	 * 设置：死亡备注
	 */
    public String getSiwanghuanzheContent() {
        return siwanghuanzheContent;
    }
    /**
	 * 获取：死亡备注
	 */

    public void setSiwanghuanzheContent(String siwanghuanzheContent) {
        this.siwanghuanzheContent = siwanghuanzheContent;
    }
    /**
	 * 设置：死亡时间
	 */
    public Date getQuezhenTime() {
        return quezhenTime;
    }
    /**
	 * 获取：死亡时间
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
        return "Siwanghuanzhe{" +
            "id=" + id +
            ", huanzheId=" + huanzheId +
            ", siwanghuanzheUuidNumber=" + siwanghuanzheUuidNumber +
            ", siwanghuanzheContent=" + siwanghuanzheContent +
            ", quezhenTime=" + quezhenTime +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
