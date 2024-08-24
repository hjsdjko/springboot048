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


import com.cl.dao.AnlileixingDao;
import com.cl.entity.AnlileixingEntity;
import com.cl.service.AnlileixingService;
import com.cl.entity.view.AnlileixingView;

@Service("anlileixingService")
public class AnlileixingServiceImpl extends ServiceImpl<AnlileixingDao, AnlileixingEntity> implements AnlileixingService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<AnlileixingEntity> wrapper) {
		Page<AnlileixingView> page =new Query<AnlileixingView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AnlileixingEntity> page = this.selectPage(
                new Query<AnlileixingEntity>(params).getPage(),
                new EntityWrapper<AnlileixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<AnlileixingEntity> wrapper) {
		  Page<AnlileixingView> page =new Query<AnlileixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<AnlileixingView> selectListView(Wrapper<AnlileixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public AnlileixingView selectView(Wrapper<AnlileixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
