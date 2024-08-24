package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.YuyueyishengDao;
import com.cl.entity.YuyueyishengEntity;
import com.cl.service.YuyueyishengService;
import com.cl.entity.view.YuyueyishengView;

@Service("yuyueyishengService")
public class YuyueyishengServiceImpl extends ServiceImpl<YuyueyishengDao, YuyueyishengEntity> implements YuyueyishengService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<YuyueyishengEntity> wrapper) {
		Page<YuyueyishengView> page =new Query<YuyueyishengView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YuyueyishengEntity> page = this.selectPage(
                new Query<YuyueyishengEntity>(params).getPage(),
                new EntityWrapper<YuyueyishengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YuyueyishengEntity> wrapper) {
		  Page<YuyueyishengView> page =new Query<YuyueyishengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YuyueyishengView> selectListView(Wrapper<YuyueyishengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YuyueyishengView selectView(Wrapper<YuyueyishengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<YuyueyishengEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<YuyueyishengEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<YuyueyishengEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
