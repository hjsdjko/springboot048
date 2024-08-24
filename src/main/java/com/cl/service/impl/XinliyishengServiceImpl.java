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


import com.cl.dao.XinliyishengDao;
import com.cl.entity.XinliyishengEntity;
import com.cl.service.XinliyishengService;
import com.cl.entity.view.XinliyishengView;

@Service("xinliyishengService")
public class XinliyishengServiceImpl extends ServiceImpl<XinliyishengDao, XinliyishengEntity> implements XinliyishengService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<XinliyishengEntity> wrapper) {
		Page<XinliyishengView> page =new Query<XinliyishengView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XinliyishengEntity> page = this.selectPage(
                new Query<XinliyishengEntity>(params).getPage(),
                new EntityWrapper<XinliyishengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XinliyishengEntity> wrapper) {
		  Page<XinliyishengView> page =new Query<XinliyishengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<XinliyishengView> selectListView(Wrapper<XinliyishengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XinliyishengView selectView(Wrapper<XinliyishengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
