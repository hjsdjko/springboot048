package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.AnlixinxiEntity;
import com.cl.entity.view.AnlixinxiView;

import com.cl.service.AnlixinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 案例信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-09 15:54:50
 */
@RestController
@RequestMapping("/anlixinxi")
public class AnlixinxiController {
    @Autowired
    private AnlixinxiService anlixinxiService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,AnlixinxiEntity anlixinxi,
		HttpServletRequest request){
        EntityWrapper<AnlixinxiEntity> ew = new EntityWrapper<AnlixinxiEntity>();

		PageUtils page = anlixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, anlixinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,AnlixinxiEntity anlixinxi, 
		HttpServletRequest request){
        EntityWrapper<AnlixinxiEntity> ew = new EntityWrapper<AnlixinxiEntity>();

		PageUtils page = anlixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, anlixinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( AnlixinxiEntity anlixinxi){
       	EntityWrapper<AnlixinxiEntity> ew = new EntityWrapper<AnlixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( anlixinxi, "anlixinxi")); 
        return R.ok().put("data", anlixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(AnlixinxiEntity anlixinxi){
        EntityWrapper< AnlixinxiEntity> ew = new EntityWrapper< AnlixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( anlixinxi, "anlixinxi")); 
		AnlixinxiView anlixinxiView =  anlixinxiService.selectView(ew);
		return R.ok("查询案例信息成功").put("data", anlixinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        AnlixinxiEntity anlixinxi = anlixinxiService.selectById(id);
		anlixinxi = anlixinxiService.selectView(new EntityWrapper<AnlixinxiEntity>().eq("id", id));
        return R.ok().put("data", anlixinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        AnlixinxiEntity anlixinxi = anlixinxiService.selectById(id);
		anlixinxi = anlixinxiService.selectView(new EntityWrapper<AnlixinxiEntity>().eq("id", id));
        return R.ok().put("data", anlixinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody AnlixinxiEntity anlixinxi, HttpServletRequest request){
    	anlixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(anlixinxi);
        anlixinxiService.insert(anlixinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody AnlixinxiEntity anlixinxi, HttpServletRequest request){
    	anlixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(anlixinxi);
        anlixinxiService.insert(anlixinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody AnlixinxiEntity anlixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(anlixinxi);
        anlixinxiService.updateById(anlixinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        anlixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
