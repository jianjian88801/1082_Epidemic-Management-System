package com.entity.model;

import com.entity.SiwanghuanzheEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 死亡患者
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class SiwanghuanzheModel implements Serializable {
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
     * 死亡患者编号
     */
    private String siwanghuanzheUuidNumber;


    /**
     * 死亡备注
     */
    private String siwanghuanzheContent;


    /**
     * 死亡时间
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
	 * 获取：死亡患者编号
	 */
    public String getSiwanghuanzheUuidNumber() {
        return siwanghuanzheUuidNumber;
    }


    /**
	 * 设置：死亡患者编号
	 */
    public void setSiwanghuanzheUuidNumber(String siwanghuanzheUuidNumber) {
        this.siwanghuanzheUuidNumber = siwanghuanzheUuidNumber;
    }
    /**
	 * 获取：死亡备注
	 */
    public String getSiwanghuanzheContent() {
        return siwanghuanzheContent;
    }


    /**
	 * 设置：死亡备注
	 */
    public void setSiwanghuanzheContent(String siwanghuanzheContent) {
        this.siwanghuanzheContent = siwanghuanzheContent;
    }
    /**
	 * 获取：死亡时间
	 */
    public Date getQuezhenTime() {
        return quezhenTime;
    }


    /**
	 * 设置：死亡时间
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
