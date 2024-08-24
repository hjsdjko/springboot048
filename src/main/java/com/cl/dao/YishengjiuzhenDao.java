package com.cl.dao;

import com.cl.entity.YishengjiuzhenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YishengjiuzhenView;


/**
 * 医生就诊
 * 
 * @author 
 * @email 
 * @date 2024-04-09 15:54:50
 */
public interface YishengjiuzhenDao extends BaseMapper<YishengjiuzhenEntity> {
	
	List<YishengjiuzhenView> selectListView(@Param("ew") Wrapper<YishengjiuzhenEntity> wrapper);

	List<YishengjiuzhenView> selectListView(Pagination page,@Param("ew") Wrapper<YishengjiuzhenEntity> wrapper);
	
	YishengjiuzhenView selectView(@Param("ew") Wrapper<YishengjiuzhenEntity> wrapper);
	
	List<YishengjiuzhenView> selectGroupBy(Pagination page,@Param("ew") Wrapper<YishengjiuzhenEntity> wrapper);

}
