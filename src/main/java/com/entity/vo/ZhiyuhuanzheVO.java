package com.entity.vo;

import com.entity.ZhiyuhuanzheEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 治愈患者
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("zhiyuhuanzhe")
public class ZhiyuhuanzheVO implements Serializable {
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

}
