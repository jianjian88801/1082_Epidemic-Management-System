package com.entity.view;

import com.entity.SiwanghuanzheEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 死亡患者
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("siwanghuanzhe")
public class SiwanghuanzheView extends SiwanghuanzheEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 huanzhe
			/**
			* 患者姓名
			*/
			private String huanzheName;
			/**
			* 患者手机号
			*/
			private String huanzhePhone;
			/**
			* 患者身份证号
			*/
			private String huanzheIdNumber;
			/**
			* 患者头像
			*/
			private String huanzhePhoto;
			/**
			* 性别
			*/
			private Integer sexTypes;
				/**
				* 性别的值
				*/
				private String sexValue;
			/**
			* 电子邮箱
			*/
			private String huanzheEmail;
			/**
			* 患者住址
			*/
			private String huanzheZhuzhi;

	public SiwanghuanzheView() {

	}

	public SiwanghuanzheView(SiwanghuanzheEntity siwanghuanzheEntity) {
		try {
			BeanUtils.copyProperties(this, siwanghuanzheEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}









				//级联表的get和set huanzhe

					/**
					* 获取： 患者姓名
					*/
					public String getHuanzheName() {
						return huanzheName;
					}
					/**
					* 设置： 患者姓名
					*/
					public void setHuanzheName(String huanzheName) {
						this.huanzheName = huanzheName;
					}

					/**
					* 获取： 患者手机号
					*/
					public String getHuanzhePhone() {
						return huanzhePhone;
					}
					/**
					* 设置： 患者手机号
					*/
					public void setHuanzhePhone(String huanzhePhone) {
						this.huanzhePhone = huanzhePhone;
					}

					/**
					* 获取： 患者身份证号
					*/
					public String getHuanzheIdNumber() {
						return huanzheIdNumber;
					}
					/**
					* 设置： 患者身份证号
					*/
					public void setHuanzheIdNumber(String huanzheIdNumber) {
						this.huanzheIdNumber = huanzheIdNumber;
					}

					/**
					* 获取： 患者头像
					*/
					public String getHuanzhePhoto() {
						return huanzhePhoto;
					}
					/**
					* 设置： 患者头像
					*/
					public void setHuanzhePhoto(String huanzhePhoto) {
						this.huanzhePhoto = huanzhePhoto;
					}

					/**
					* 获取： 性别
					*/
					public Integer getSexTypes() {
						return sexTypes;
					}
					/**
					* 设置： 性别
					*/
					public void setSexTypes(Integer sexTypes) {
						this.sexTypes = sexTypes;
					}


						/**
						* 获取： 性别的值
						*/
						public String getSexValue() {
							return sexValue;
						}
						/**
						* 设置： 性别的值
						*/
						public void setSexValue(String sexValue) {
							this.sexValue = sexValue;
						}

					/**
					* 获取： 电子邮箱
					*/
					public String getHuanzheEmail() {
						return huanzheEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setHuanzheEmail(String huanzheEmail) {
						this.huanzheEmail = huanzheEmail;
					}

					/**
					* 获取： 患者住址
					*/
					public String getHuanzheZhuzhi() {
						return huanzheZhuzhi;
					}
					/**
					* 设置： 患者住址
					*/
					public void setHuanzheZhuzhi(String huanzheZhuzhi) {
						this.huanzheZhuzhi = huanzheZhuzhi;
					}














}
