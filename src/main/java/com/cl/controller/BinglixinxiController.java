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

import com.cl.entity.BinglixinxiEntity;
import com.cl.entity.view.BinglixinxiView;

import com.cl.service.BinglixinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 病历信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-09 15:54:50
 */
@RestController
@RequestMapping("/binglixinxi")
public class BinglixinxiController {
    @Autowired
    private BinglixinxiService binglixinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,BinglixinxiEntity binglixinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			binglixinxi.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xinliyisheng")) {
			binglixinxi.setYishengzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<BinglixinxiEntity> ew = new EntityWrapper<BinglixinxiEntity>();

		PageUtils page = binglixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, binglixinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,BinglixinxiEntity binglixinxi, 
		HttpServletRequest request){
        EntityWrapper<BinglixinxiEntity> ew = new EntityWrapper<BinglixinxiEntity>();

		PageUtils page = binglixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, binglixinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( BinglixinxiEntity binglixinxi){
       	EntityWrapper<BinglixinxiEntity> ew = new EntityWrapper<BinglixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( binglixinxi, "binglixinxi")); 
        return R.ok().put("data", binglixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(BinglixinxiEntity binglixinxi){
        EntityWrapper< BinglixinxiEntity> ew = new EntityWrapper< BinglixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( binglixinxi, "binglixinxi")); 
		BinglixinxiView binglixinxiView =  binglixinxiService.selectView(ew);
		return R.ok("查询病历信息成功").put("data", binglixinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        BinglixinxiEntity binglixinxi = binglixinxiService.selectById(id);
		binglixinxi = binglixinxiService.selectView(new EntityWrapper<BinglixinxiEntity>().eq("id", id));
        return R.ok().put("data", binglixinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        BinglixinxiEntity binglixinxi = binglixinxiService.selectById(id);
		binglixinxi = binglixinxiService.selectView(new EntityWrapper<BinglixinxiEntity>().eq("id", id));
        return R.ok().put("data", binglixinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody BinglixinxiEntity binglixinxi, HttpServletRequest request){
    	binglixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(binglixinxi);
        binglixinxiService.insert(binglixinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody BinglixinxiEntity binglixinxi, HttpServletRequest request){
    	binglixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(binglixinxi);
        binglixinxiService.insert(binglixinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody BinglixinxiEntity binglixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(binglixinxi);
        binglixinxiService.updateById(binglixinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        binglixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
