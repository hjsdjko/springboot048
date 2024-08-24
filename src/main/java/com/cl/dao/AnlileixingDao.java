package com.cl.dao;

import com.cl.entity.AnlileixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.AnlileixingView;


/**
 * 案例类型
 * 
 * @author 
 * @email 
 * @date 2024-04-09 15:54:51
 */
public interface AnlileixingDao extends BaseMapper<AnlileixingEntity> {
	
	List<AnlileixingView> selectListView(@Param("ew") Wrapper<AnlileixingEntity> wrapper);

	List<AnlileixingView> selectListView(Pagination page,@Param("ew") Wrapper<AnlileixingEntity> wrapper);
	
	AnlileixingView selectView(@Param("ew") Wrapper<AnlileixingEntity> wrapper);
	
	List<AnlileixingView> selectGroupBy(Pagination page,@Param("ew") Wrapper<AnlileixingEntity> wrapper);

}
