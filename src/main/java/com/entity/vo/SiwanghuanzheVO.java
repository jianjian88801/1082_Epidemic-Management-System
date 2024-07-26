package com.entity.vo;

import com.entity.SiwanghuanzheEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 死亡患者
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("siwanghuanzhe")
public class SiwanghuanzheVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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

}
