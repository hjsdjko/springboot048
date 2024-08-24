package com.cl.entity.view;

import com.cl.entity.BinglixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 病历信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-09 15:54:50
 */
@TableName("binglixinxi")
public class BinglixinxiView  extends BinglixinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public BinglixinxiView(){
	}
 
 	public BinglixinxiView(BinglixinxiEntity binglixinxiEntity){
 	try {
			BeanUtils.copyProperties(this, binglixinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
