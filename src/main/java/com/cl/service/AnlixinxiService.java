package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.AnlixinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.AnlixinxiView;


/**
 * 案例信息
 *
 * @author 
 * @email 
 * @date 2024-04-09 15:54:50
 */
public interface AnlixinxiService extends IService<AnlixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<AnlixinxiView> selectListView(Wrapper<AnlixinxiEntity> wrapper);
   	
   	AnlixinxiView selectView(@Param("ew") Wrapper<AnlixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<AnlixinxiEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<AnlixinxiEntity> wrapper);

}

