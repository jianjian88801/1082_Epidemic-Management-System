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
 * 治愈患者
 *
 * @author 
 * @email
 */
@TableName("zhiyuhuanzhe")
public class ZhiyuhuanzheEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZhiyuhuanzheEntity() {

	}

	public ZhiyuhuanzheEntity(T t) {
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
     * 治愈患者编号
     */
    @TableField(value = "zhiyuhuanzhe_uuid_number")

    private String zhiyuhuanzheUuidNumber;


    /**
     * 治愈备注
     */
    @TableField(value = "zhiyuhuanzhe_content")

    private String zhiyuhuanzheContent;


    /**
     * 治愈时间
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
	 * 设置：治愈患者编号
	 */
    public String getZhiyuhuanzheUuidNumber() {
        return zhiyuhuanzheUuidNumber;
    }
    /**
	 * 获取：治愈患者编号
	 */

    public void setZhiyuhuanzheUuidNumber(String zhiyuhuanzheUuidNumber) {
        this.zhiyuhuanzheUuidNumber = zhiyuhuanzheUuidNumber;
    }
    /**
	 * 设置：治愈备注
	 */
    public String getZhiyuhuanzheContent() {
        return zhiyuhuanzheContent;
    }
    /**
	 * 获取：治愈备注
	 */

    public void setZhiyuhuanzheContent(String zhiyuhuanzheContent) {
        this.zhiyuhuanzheContent = zhiyuhuanzheContent;
    }
    /**
	 * 设置：治愈时间
	 */
    public Date getQuezhenTime() {
        return quezhenTime;
    }
    /**
	 * 获取：治愈时间
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
        return "Zhiyuhuanzhe{" +
            "id=" + id +
            ", huanzheId=" + huanzheId +
            ", zhiyuhuanzheUuidNumber=" + zhiyuhuanzheUuidNumber +
            ", zhiyuhuanzheContent=" + zhiyuhuanzheContent +
            ", quezhenTime=" + quezhenTime +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
