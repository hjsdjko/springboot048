package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.QuxiaoyuyueEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.QuxiaoyuyueView;


/**
 * 取消预约
 *
 * @author 
 * @email 
 * @date 2024-04-09 15:54:50
 */
public interface QuxiaoyuyueService extends IService<QuxiaoyuyueEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<QuxiaoyuyueView> selectListView(Wrapper<QuxiaoyuyueEntity> wrapper);
   	
   	QuxiaoyuyueView selectView(@Param("ew") Wrapper<QuxiaoyuyueEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<QuxiaoyuyueEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<QuxiaoyuyueEntity> wrapper);

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<QuxiaoyuyueEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<QuxiaoyuyueEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<QuxiaoyuyueEntity> wrapper);



}

