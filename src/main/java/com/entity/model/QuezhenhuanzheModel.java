package com.entity.model;

import com.entity.QuezhenhuanzheEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 确诊患者
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class QuezhenhuanzheModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 患者
     */
    private Integer huanzheId;


    /**
     * 确诊患者编号
     */
    private String quezhenhuanzheUuidNumber;


    /**
     * 确诊位置
     */
    private String quezhenhuanzheGeliAddress;


    /**
     * 确诊备注
     */
    private String quezhenhuanzheContent;


    /**
     * 确诊时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date quezhenTime;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：患者
	 */
    public Integer getHuanzheId() {
        return huanzheId;
    }


    /**
	 * 设置：患者
	 */
    public void setHuanzheId(Integer huanzheId) {
        this.huanzheId = huanzheId;
    }
    /**
	 * 获取：确诊患者编号
	 */
    public String getQuezhenhuanzheUuidNumber() {
        return quezhenhuanzheUuidNumber;
    }


    /**
	 * 设置：确诊患者编号
	 */
    public void setQuezhenhuanzheUuidNumber(String quezhenhuanzheUuidNumber) {
        this.quezhenhuanzheUuidNumber = quezhenhuanzheUuidNumber;
    }
    /**
	 * 获取：确诊位置
	 */
    public String getQuezhenhuanzheGeliAddress() {
        return quezhenhuanzheGeliAddress;
    }


    /**
	 * 设置：确诊位置
	 */
    public void setQuezhenhuanzheGeliAddress(String quezhenhuanzheGeliAddress) {
        this.quezhenhuanzheGeliAddress = quezhenhuanzheGeliAddress;
    }
    /**
	 * 获取：确诊备注
	 */
    public String getQuezhenhuanzheContent() {
        return quezhenhuanzheContent;
    }


    /**
	 * 设置：确诊备注
	 */
    public void setQuezhenhuanzheContent(String quezhenhuanzheContent) {
        this.quezhenhuanzheContent = quezhenhuanzheContent;
    }
    /**
	 * 获取：确诊时间
	 */
    public Date getQuezhenTime() {
        return quezhenTime;
    }


    /**
	 * 设置：确诊时间
	 */
    public void setQuezhenTime(Date quezhenTime) {
        this.quezhenTime = quezhenTime;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：录入时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
