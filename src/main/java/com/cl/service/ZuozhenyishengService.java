package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZuozhenyishengEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZuozhenyishengView;


/**
 * 坐诊医生
 *
 * @author 
 * @email 
 * @date 2024-04-09 15:54:50
 */
public interface ZuozhenyishengService extends IService<ZuozhenyishengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZuozhenyishengView> selectListView(Wrapper<ZuozhenyishengEntity> wrapper);
   	
   	ZuozhenyishengView selectView(@Param("ew") Wrapper<ZuozhenyishengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZuozhenyishengEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<ZuozhenyishengEntity> wrapper);

}

