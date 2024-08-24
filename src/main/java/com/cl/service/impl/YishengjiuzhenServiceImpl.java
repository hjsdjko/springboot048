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


import com.cl.dao.YishengjiuzhenDao;
import com.cl.entity.YishengjiuzhenEntity;
import com.cl.service.YishengjiuzhenService;
import com.cl.entity.view.YishengjiuzhenView;

@Service("yishengjiuzhenService")
public class YishengjiuzhenServiceImpl extends ServiceImpl<YishengjiuzhenDao, YishengjiuzhenEntity> implements YishengjiuzhenService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<YishengjiuzhenEntity> wrapper) {
		Page<YishengjiuzhenView> page =new Query<YishengjiuzhenView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YishengjiuzhenEntity> page = this.selectPage(
                new Query<YishengjiuzhenEntity>(params).getPage(),
                new EntityWrapper<YishengjiuzhenEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YishengjiuzhenEntity> wrapper) {
		  Page<YishengjiuzhenView> page =new Query<YishengjiuzhenView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YishengjiuzhenView> selectListView(Wrapper<YishengjiuzhenEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YishengjiuzhenView selectView(Wrapper<YishengjiuzhenEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
