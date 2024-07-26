package com.entity.vo;

import com.entity.MiqiejiechuzheEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 密切接触者
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("miqiejiechuzhe")
public class MiqiejiechuzheVO implements Serializable {
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

}
