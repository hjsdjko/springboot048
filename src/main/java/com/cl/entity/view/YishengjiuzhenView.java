package com.cl.entity.view;

import com.cl.entity.YishengjiuzhenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 医生就诊
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-09 15:54:50
 */
@TableName("yishengjiuzhen")
public class YishengjiuzhenView  extends YishengjiuzhenEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YishengjiuzhenView(){
	}
 
 	public YishengjiuzhenView(YishengjiuzhenEntity yishengjiuzhenEntity){
 	try {
			BeanUtils.copyProperties(this, yishengjiuzhenEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}