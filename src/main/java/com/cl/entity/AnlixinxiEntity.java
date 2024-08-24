package com.cl.entity;

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
 * 案例信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-09 15:54:50
 */
@TableName("anlixinxi")
public class AnlixinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public AnlixinxiEntity() {
		
	}
	
	public AnlixinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 案例名称
	 */
					
	private String anlimingcheng;
	
	/**
	 * 图片
	 */
					
	private String tupian;
	
	/**
	 * 案例类型
	 */
					
	private String anlileixing;
	
	/**
	 * 案例视频
	 */
					
	private String anlishipin;
	
	/**
	 * 案例详情
	 */
					
	private String anlixiangqing;
	
	/**
	 * 发布时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date fabushijian;
	
	/**
	 * 收藏数量
	 */
					
	private Integer storeupnum;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：案例名称
	 */
	public void setAnlimingcheng(String anlimingcheng) {
		this.anlimingcheng = anlimingcheng;
	}
	/**
	 * 获取：案例名称
	 */
	public String getAnlimingcheng() {
		return anlimingcheng;
	}
	/**
	 * 设置：图片
	 */
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
	/**
	 * 设置：案例类型
	 */
	public void setAnlileixing(String anlileixing) {
		this.anlileixing = anlileixing;
	}
	/**
	 * 获取：案例类型
	 */
	public String getAnlileixing() {
		return anlileixing;
	}
	/**
	 * 设置：案例视频
	 */
	public void setAnlishipin(String anlishipin) {
		this.anlishipin = anlishipin;
	}
	/**
	 * 获取：案例视频
	 */
	public String getAnlishipin() {
		return anlishipin;
	}
	/**
	 * 设置：案例详情
	 */
	public void setAnlixiangqing(String anlixiangqing) {
		this.anlixiangqing = anlixiangqing;
	}
	/**
	 * 获取：案例详情
	 */
	public String getAnlixiangqing() {
		return anlixiangqing;
	}
	/**
	 * 设置：发布时间
	 */
	public void setFabushijian(Date fabushijian) {
		this.fabushijian = fabushijian;
	}
	/**
	 * 获取：发布时间
	 */
	public Date getFabushijian() {
		return fabushijian;
	}
	/**
	 * 设置：收藏数量
	 */
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	/**
	 * 获取：收藏数量
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}

}
