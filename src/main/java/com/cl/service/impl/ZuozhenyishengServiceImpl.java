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


import com.cl.dao.ZuozhenyishengDao;
import com.cl.entity.ZuozhenyishengEntity;
import com.cl.service.ZuozhenyishengService;
import com.cl.entity.view.ZuozhenyishengView;

@Service("zuozhenyishengService")
public class ZuozhenyishengServiceImpl extends ServiceImpl<ZuozhenyishengDao, ZuozhenyishengEntity> implements ZuozhenyishengService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<ZuozhenyishengEntity> wrapper) {
		Page<ZuozhenyishengView> page =new Query<ZuozhenyishengView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZuozhenyishengEntity> page = this.selectPage(
                new Query<ZuozhenyishengEntity>(params).getPage(),
                new EntityWrapper<ZuozhenyishengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZuozhenyishengEntity> wrapper) {
		  Page<ZuozhenyishengView> page =new Query<ZuozhenyishengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ZuozhenyishengView> selectListView(Wrapper<ZuozhenyishengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZuozhenyishengView selectView(Wrapper<ZuozhenyishengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
