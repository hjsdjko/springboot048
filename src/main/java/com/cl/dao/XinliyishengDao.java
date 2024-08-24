package com.cl.dao;

import com.cl.entity.XinliyishengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XinliyishengView;


/**
 * 心理医生
 * 
 * @author 
 * @email 
 * @date 2024-04-09 15:54:50
 */
public interface XinliyishengDao extends BaseMapper<XinliyishengEntity> {
	
	List<XinliyishengView> selectListView(@Param("ew") Wrapper<XinliyishengEntity> wrapper);

	List<XinliyishengView> selectListView(Pagination page,@Param("ew") Wrapper<XinliyishengEntity> wrapper);
	
	XinliyishengView selectView(@Param("ew") Wrapper<XinliyishengEntity> wrapper);
	
	List<XinliyishengView> selectGroupBy(Pagination page,@Param("ew") Wrapper<XinliyishengEntity> wrapper);

}
