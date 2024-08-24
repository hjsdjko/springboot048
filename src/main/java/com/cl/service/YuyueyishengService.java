package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YuyueyishengEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YuyueyishengView;


/**
 * 预约医生
 *
 * @author 
 * @email 
 * @date 2024-04-09 15:54:50
 */
public interface YuyueyishengService extends IService<YuyueyishengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YuyueyishengView> selectListView(Wrapper<YuyueyishengEntity> wrapper);
   	
   	YuyueyishengView selectView(@Param("ew") Wrapper<YuyueyishengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YuyueyishengEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<YuyueyishengEntity> wrapper);

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<YuyueyishengEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<YuyueyishengEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<YuyueyishengEntity> wrapper);



}

