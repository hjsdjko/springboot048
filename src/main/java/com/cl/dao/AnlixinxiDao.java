package com.cl.dao;

import com.cl.entity.AnlixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.AnlixinxiView;


/**
 * 案例信息
 * 
 * @author 
 * @email 
 * @date 2024-04-09 15:54:50
 */
public interface AnlixinxiDao extends BaseMapper<AnlixinxiEntity> {
	
	List<AnlixinxiView> selectListView(@Param("ew") Wrapper<AnlixinxiEntity> wrapper);

	List<AnlixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<AnlixinxiEntity> wrapper);
	
	AnlixinxiView selectView(@Param("ew") Wrapper<AnlixinxiEntity> wrapper);
	
	List<AnlixinxiView> selectGroupBy(Pagination page,@Param("ew") Wrapper<AnlixinxiEntity> wrapper);

}
