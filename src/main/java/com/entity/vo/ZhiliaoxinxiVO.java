package com.entity.vo;

import com.entity.ZhiliaoxinxiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 治疗信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("zhiliaoxinxi")
public class ZhiliaoxinxiVO implements Serializable {
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
     * 治疗信息编号
     */

    @TableField(value = "zhiliaoxinxi_uuid_number")
    private String zhiliaoxinxiUuidNumber;


    /**
     * 感染源
     */

    @TableField(value = "ganranyuan")
    private String ganranyuan;


    /**
     * 是否重症
     */

    @TableField(value = "zhongzheng_types")
    private Integer zhongzhengTypes;


    /**
     * 住院时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "zhuyuan_time")
    private Date zhuyuanTime;


    /**
     * 发病症状
     */

    @TableField(value = "fabing_zhengzhuang")
    private String fabingZhengzhuang;


    /**
     * 诊治医院
     */

    @TableField(value = "zhenzhiyiyuan")
    private String zhenzhiyiyuan;


    /**
     * 核酸检测
     */

    @TableField(value = "hesuanjiance_text")
    private String hesuanjianceText;


    /**
     * CT检测史
     */

    @TableField(value = "ctjiance_text")
    private String ctjianceText;


    /**
     * 信息备注
     */

    @TableField(value = "zhiliaoxinxi_content")
    private String zhiliaoxinxiContent;


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
	 * 设置：治疗信息编号
	 */
    public String getZhiliaoxinxiUuidNumber() {
        return zhiliaoxinxiUuidNumber;
    }


    /**
	 * 获取：治疗信息编号
	 */

    public void setZhiliaoxinxiUuidNumber(String zhiliaoxinxiUuidNumber) {
        this.zhiliaoxinxiUuidNumber = zhiliaoxinxiUuidNumber;
    }
    /**
	 * 设置：感染源
	 */
    public String getGanranyuan() {
        return ganranyuan;
    }


    /**
	 * 获取：感染源
	 */

    public void setGanranyuan(String ganranyuan) {
        this.ganranyuan = ganranyuan;
    }
    /**
	 * 设置：是否重症
	 */
    public Integer getZhongzhengTypes() {
        return zhongzhengTypes;
    }


    /**
	 * 获取：是否重症
	 */

    public void setZhongzhengTypes(Integer zhongzhengTypes) {
        this.zhongzhengTypes = zhongzhengTypes;
    }
    /**
	 * 设置：住院时间
	 */
    public Date getZhuyuanTime() {
        return zhuyuanTime;
    }


    /**
	 * 获取：住院时间
	 */

    public void setZhuyuanTime(Date zhuyuanTime) {
        this.zhuyuanTime = zhuyuanTime;
    }
    /**
	 * 设置：发病症状
	 */
    public String getFabingZhengzhuang() {
        return fabingZhengzhuang;
    }


    /**
	 * 获取：发病症状
	 */

    public void setFabingZhengzhuang(String fabingZhengzhuang) {
        this.fabingZhengzhuang = fabingZhengzhuang;
    }
    /**
	 * 设置：诊治医院
	 */
    public String getZhenzhiyiyuan() {
        return zhenzhiyiyuan;
    }


    /**
	 * 获取：诊治医院
	 */

    public void setZhenzhiyiyuan(String zhenzhiyiyuan) {
        this.zhenzhiyiyuan = zhenzhiyiyuan;
    }
    /**
	 * 设置：核酸检测
	 */
    public String getHesuanjianceText() {
        return hesuanjianceText;
    }


    /**
	 * 获取：核酸检测
	 */

    public void setHesuanjianceText(String hesuanjianceText) {
        this.hesuanjianceText = hesuanjianceText;
    }
    /**
	 * 设置：CT检测史
	 */
    public String getCtjianceText() {
        return ctjianceText;
    }


    /**
	 * 获取：CT检测史
	 */

    public void setCtjianceText(String ctjianceText) {
        this.ctjianceText = ctjianceText;
    }
    /**
	 * 设置：信息备注
	 */
    public String getZhiliaoxinxiContent() {
        return zhiliaoxinxiContent;
    }


    /**
	 * 获取：信息备注
	 */

    public void setZhiliaoxinxiContent(String zhiliaoxinxiContent) {
        this.zhiliaoxinxiContent = zhiliaoxinxiContent;
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
