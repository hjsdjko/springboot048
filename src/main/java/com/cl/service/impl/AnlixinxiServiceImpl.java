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


import com.cl.dao.AnlixinxiDao;
import com.cl.entity.AnlixinxiEntity;
import com.cl.service.AnlixinxiService;
import com.cl.entity.view.AnlixinxiView;

@Service("anlixinxiService")
public class AnlixinxiServiceImpl extends ServiceImpl<AnlixinxiDao, AnlixinxiEntity> implements AnlixinxiService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<AnlixinxiEntity> wrapper) {
		Page<AnlixinxiView> page =new Query<AnlixinxiView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AnlixinxiEntity> page = this.selectPage(
                new Query<AnlixinxiEntity>(params).getPage(),
                new EntityWrapper<AnlixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<AnlixinxiEntity> wrapper) {
		  Page<AnlixinxiView> page =new Query<AnlixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<AnlixinxiView> selectListView(Wrapper<AnlixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public AnlixinxiView selectView(Wrapper<AnlixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
