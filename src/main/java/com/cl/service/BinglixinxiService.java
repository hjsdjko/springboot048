package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.BinglixinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.BinglixinxiView;


/**
 * 病历信息
 *
 * @author 
 * @email 
 * @date 2024-04-09 15:54:50
 */
public interface BinglixinxiService extends IService<BinglixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BinglixinxiView> selectListView(Wrapper<BinglixinxiEntity> wrapper);
   	
   	BinglixinxiView selectView(@Param("ew") Wrapper<BinglixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BinglixinxiEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<BinglixinxiEntity> wrapper);

}

