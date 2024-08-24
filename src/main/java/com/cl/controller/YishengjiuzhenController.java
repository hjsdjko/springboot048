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

import com.cl.entity.YishengjiuzhenEntity;
import com.cl.entity.view.YishengjiuzhenView;

import com.cl.service.YishengjiuzhenService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 医生就诊
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-09 15:54:50
 */
@RestController
@RequestMapping("/yishengjiuzhen")
public class YishengjiuzhenController {
    @Autowired
    private YishengjiuzhenService yishengjiuzhenService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YishengjiuzhenEntity yishengjiuzhen,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xinliyisheng")) {
			yishengjiuzhen.setYishengzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			yishengjiuzhen.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YishengjiuzhenEntity> ew = new EntityWrapper<YishengjiuzhenEntity>();

		PageUtils page = yishengjiuzhenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yishengjiuzhen), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YishengjiuzhenEntity yishengjiuzhen, 
		HttpServletRequest request){
        EntityWrapper<YishengjiuzhenEntity> ew = new EntityWrapper<YishengjiuzhenEntity>();

		PageUtils page = yishengjiuzhenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yishengjiuzhen), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YishengjiuzhenEntity yishengjiuzhen){
       	EntityWrapper<YishengjiuzhenEntity> ew = new EntityWrapper<YishengjiuzhenEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yishengjiuzhen, "yishengjiuzhen")); 
        return R.ok().put("data", yishengjiuzhenService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YishengjiuzhenEntity yishengjiuzhen){
        EntityWrapper< YishengjiuzhenEntity> ew = new EntityWrapper< YishengjiuzhenEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yishengjiuzhen, "yishengjiuzhen")); 
		YishengjiuzhenView yishengjiuzhenView =  yishengjiuzhenService.selectView(ew);
		return R.ok("查询医生就诊成功").put("data", yishengjiuzhenView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YishengjiuzhenEntity yishengjiuzhen = yishengjiuzhenService.selectById(id);
		yishengjiuzhen = yishengjiuzhenService.selectView(new EntityWrapper<YishengjiuzhenEntity>().eq("id", id));
        return R.ok().put("data", yishengjiuzhen);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YishengjiuzhenEntity yishengjiuzhen = yishengjiuzhenService.selectById(id);
		yishengjiuzhen = yishengjiuzhenService.selectView(new EntityWrapper<YishengjiuzhenEntity>().eq("id", id));
        return R.ok().put("data", yishengjiuzhen);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YishengjiuzhenEntity yishengjiuzhen, HttpServletRequest request){
    	yishengjiuzhen.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yishengjiuzhen);
        yishengjiuzhenService.insert(yishengjiuzhen);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YishengjiuzhenEntity yishengjiuzhen, HttpServletRequest request){
    	yishengjiuzhen.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yishengjiuzhen);
        yishengjiuzhenService.insert(yishengjiuzhen);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YishengjiuzhenEntity yishengjiuzhen, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yishengjiuzhen);
        yishengjiuzhenService.updateById(yishengjiuzhen);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yishengjiuzhenService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
