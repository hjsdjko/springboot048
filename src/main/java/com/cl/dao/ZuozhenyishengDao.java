package com.cl.dao;

import com.cl.entity.ZuozhenyishengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZuozhenyishengView;


/**
 * 坐诊医生
 * 
 * @author 
 * @email 
 * @date 2024-04-09 15:54:50
 */
public interface ZuozhenyishengDao extends BaseMapper<ZuozhenyishengEntity> {
	
	List<ZuozhenyishengView> selectListView(@Param("ew") Wrapper<ZuozhenyishengEntity> wrapper);

	List<ZuozhenyishengView> selectListView(Pagination page,@Param("ew") Wrapper<ZuozhenyishengEntity> wrapper);
	
	ZuozhenyishengView selectView(@Param("ew") Wrapper<ZuozhenyishengEntity> wrapper);
	
	List<ZuozhenyishengView> selectGroupBy(Pagination page,@Param("ew") Wrapper<ZuozhenyishengEntity> wrapper);

}
