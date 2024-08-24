package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.AnlileixingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.AnlileixingView;


/**
 * 案例类型
 *
 * @author 
 * @email 
 * @date 2024-04-09 15:54:51
 */
public interface AnlileixingService extends IService<AnlileixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<AnlileixingView> selectListView(Wrapper<AnlileixingEntity> wrapper);
   	
   	AnlileixingView selectView(@Param("ew") Wrapper<AnlileixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<AnlileixingEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<AnlileixingEntity> wrapper);

}

