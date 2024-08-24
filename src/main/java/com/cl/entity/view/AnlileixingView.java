package com.cl.entity.view;

import com.cl.entity.AnlileixingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 案例类型
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-09 15:54:51
 */
@TableName("anlileixing")
public class AnlileixingView  extends AnlileixingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public AnlileixingView(){
	}
 
 	public AnlileixingView(AnlileixingEntity anlileixingEntity){
 	try {
			BeanUtils.copyProperties(this, anlileixingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
