package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.XinliyishengEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XinliyishengView;


/**
 * 心理医生
 *
 * @author 
 * @email 
 * @date 2024-04-09 15:54:50
 */
public interface XinliyishengService extends IService<XinliyishengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XinliyishengView> selectListView(Wrapper<XinliyishengEntity> wrapper);
   	
   	XinliyishengView selectView(@Param("ew") Wrapper<XinliyishengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XinliyishengEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<XinliyishengEntity> wrapper);

}

