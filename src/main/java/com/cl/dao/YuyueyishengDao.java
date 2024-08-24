package com.cl.dao;

import com.cl.entity.YuyueyishengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YuyueyishengView;


/**
 * 预约医生
 * 
 * @author 
 * @email 
 * @date 2024-04-09 15:54:50
 */
public interface YuyueyishengDao extends BaseMapper<YuyueyishengEntity> {
	
	List<YuyueyishengView> selectListView(@Param("ew") Wrapper<YuyueyishengEntity> wrapper);

	List<YuyueyishengView> selectListView(Pagination page,@Param("ew") Wrapper<YuyueyishengEntity> wrapper);
	
	YuyueyishengView selectView(@Param("ew") Wrapper<YuyueyishengEntity> wrapper);
	
	List<YuyueyishengView> selectGroupBy(Pagination page,@Param("ew") Wrapper<YuyueyishengEntity> wrapper);

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YuyueyishengEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YuyueyishengEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YuyueyishengEntity> wrapper);



}
