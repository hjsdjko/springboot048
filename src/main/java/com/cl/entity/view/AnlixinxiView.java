package com.cl.entity.view;

import com.cl.entity.AnlixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 案例信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-09 15:54:50
 */
@TableName("anlixinxi")
public class AnlixinxiView  extends AnlixinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public AnlixinxiView(){
	}
 
 	public AnlixinxiView(AnlixinxiEntity anlixinxiEntity){
 	try {
			BeanUtils.copyProperties(this, anlixinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
