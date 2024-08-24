package com.cl.dao;

import com.cl.entity.BinglixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.BinglixinxiView;


/**
 * 病历信息
 * 
 * @author 
 * @email 
 * @date 2024-04-09 15:54:50
 */
public interface BinglixinxiDao extends BaseMapper<BinglixinxiEntity> {
	
	List<BinglixinxiView> selectListView(@Param("ew") Wrapper<BinglixinxiEntity> wrapper);

	List<BinglixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<BinglixinxiEntity> wrapper);
	
	BinglixinxiView selectView(@Param("ew") Wrapper<BinglixinxiEntity> wrapper);
	
	List<BinglixinxiView> selectGroupBy(Pagination page,@Param("ew") Wrapper<BinglixinxiEntity> wrapper);

}
