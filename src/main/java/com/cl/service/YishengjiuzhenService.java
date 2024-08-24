package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YishengjiuzhenEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YishengjiuzhenView;


/**
 * 医生就诊
 *
 * @author 
 * @email 
 * @date 2024-04-09 15:54:50
 */
public interface YishengjiuzhenService extends IService<YishengjiuzhenEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YishengjiuzhenView> selectListView(Wrapper<YishengjiuzhenEntity> wrapper);
   	
   	YishengjiuzhenView selectView(@Param("ew") Wrapper<YishengjiuzhenEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YishengjiuzhenEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<YishengjiuzhenEntity> wrapper);

}

