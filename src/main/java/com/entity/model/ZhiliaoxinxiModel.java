package com.entity.model;

import com.entity.ZhiliaoxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 治疗信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZhiliaoxinxiModel implements Serializable {
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
     * 治疗信息编号
     */
    private String zhiliaoxinxiUuidNumber;


    /**
     * 感染源
     */
    private String ganranyuan;


    /**
     * 是否重症
     */
    private Integer zhongzhengTypes;


    /**
     * 住院时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date zhuyuanTime;


    /**
     * 发病症状
     */
    private String fabingZhengzhuang;


    /**
     * 诊治医院
     */
    private String zhenzhiyiyuan;


    /**
     * 核酸检测
     */
    private String hesuanjianceText;


    /**
     * CT检测史
     */
    private String ctjianceText;


    /**
     * 信息备注
     */
    private String zhiliaoxinxiContent;


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
	 * 获取：治疗信息编号
	 */
    public String getZhiliaoxinxiUuidNumber() {
        return zhiliaoxinxiUuidNumber;
    }


    /**
	 * 设置：治疗信息编号
	 */
    public void setZhiliaoxinxiUuidNumber(String zhiliaoxinxiUuidNumber) {
        this.zhiliaoxinxiUuidNumber = zhiliaoxinxiUuidNumber;
    }
    /**
	 * 获取：感染源
	 */
    public String getGanranyuan() {
        return ganranyuan;
    }


    /**
	 * 设置：感染源
	 */
    public void setGanranyuan(String ganranyuan) {
        this.ganranyuan = ganranyuan;
    }
    /**
	 * 获取：是否重症
	 */
    public Integer getZhongzhengTypes() {
        return zhongzhengTypes;
    }


    /**
	 * 设置：是否重症
	 */
    public void setZhongzhengTypes(Integer zhongzhengTypes) {
        this.zhongzhengTypes = zhongzhengTypes;
    }
    /**
	 * 获取：住院时间
	 */
    public Date getZhuyuanTime() {
        return zhuyuanTime;
    }


    /**
	 * 设置：住院时间
	 */
    public void setZhuyuanTime(Date zhuyuanTime) {
        this.zhuyuanTime = zhuyuanTime;
    }
    /**
	 * 获取：发病症状
	 */
    public String getFabingZhengzhuang() {
        return fabingZhengzhuang;
    }


    /**
	 * 设置：发病症状
	 */
    public void setFabingZhengzhuang(String fabingZhengzhuang) {
        this.fabingZhengzhuang = fabingZhengzhuang;
    }
    /**
	 * 获取：诊治医院
	 */
    public String getZhenzhiyiyuan() {
        return zhenzhiyiyuan;
    }


    /**
	 * 设置：诊治医院
	 */
    public void setZhenzhiyiyuan(String zhenzhiyiyuan) {
        this.zhenzhiyiyuan = zhenzhiyiyuan;
    }
    /**
	 * 获取：核酸检测
	 */
    public String getHesuanjianceText() {
        return hesuanjianceText;
    }


    /**
	 * 设置：核酸检测
	 */
    public void setHesuanjianceText(String hesuanjianceText) {
        this.hesuanjianceText = hesuanjianceText;
    }
    /**
	 * 获取：CT检测史
	 */
    public String getCtjianceText() {
        return ctjianceText;
    }


    /**
	 * 设置：CT检测史
	 */
    public void setCtjianceText(String ctjianceText) {
        this.ctjianceText = ctjianceText;
    }
    /**
	 * 获取：信息备注
	 */
    public String getZhiliaoxinxiContent() {
        return zhiliaoxinxiContent;
    }


    /**
	 * 设置：信息备注
	 */
    public void setZhiliaoxinxiContent(String zhiliaoxinxiContent) {
        this.zhiliaoxinxiContent = zhiliaoxinxiContent;
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
