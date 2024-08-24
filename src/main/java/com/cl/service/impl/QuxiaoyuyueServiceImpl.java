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


import com.cl.dao.QuxiaoyuyueDao;
import com.cl.entity.QuxiaoyuyueEntity;
import com.cl.service.QuxiaoyuyueService;
import com.cl.entity.view.QuxiaoyuyueView;

@Service("quxiaoyuyueService")
public class QuxiaoyuyueServiceImpl extends ServiceImpl<QuxiaoyuyueDao, QuxiaoyuyueEntity> implements QuxiaoyuyueService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<QuxiaoyuyueEntity> wrapper) {
		Page<QuxiaoyuyueView> page =new Query<QuxiaoyuyueView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QuxiaoyuyueEntity> page = this.selectPage(
                new Query<QuxiaoyuyueEntity>(params).getPage(),
                new EntityWrapper<QuxiaoyuyueEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<QuxiaoyuyueEntity> wrapper) {
		  Page<QuxiaoyuyueView> page =new Query<QuxiaoyuyueView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<QuxiaoyuyueView> selectListView(Wrapper<QuxiaoyuyueEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QuxiaoyuyueView selectView(Wrapper<QuxiaoyuyueEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<QuxiaoyuyueEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<QuxiaoyuyueEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<QuxiaoyuyueEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
