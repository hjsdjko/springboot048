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

import com.cl.entity.XinliyishengEntity;
import com.cl.entity.view.XinliyishengView;

import com.cl.service.XinliyishengService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 心理医生
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-09 15:54:50
 */
@RestController
@RequestMapping("/xinliyisheng")
public class XinliyishengController {
    @Autowired
    private XinliyishengService xinliyishengService;



    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		XinliyishengEntity u = xinliyishengService.selectOne(new EntityWrapper<XinliyishengEntity>().eq("yishengzhanghao", username));
        if(u==null || !u.getYishengmima().equals(password)) {
            return R.error("账号或密码不正确");
        }
        if(!"是".equals(u.getSfsh())) return R.error("账号已锁定，请联系管理员审核。");
		String token = tokenService.generateToken(u.getId(), username,"xinliyisheng",  "心理医生" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody XinliyishengEntity xinliyisheng){
    	//ValidatorUtils.validateEntity(xinliyisheng);
    	XinliyishengEntity u = xinliyishengService.selectOne(new EntityWrapper<XinliyishengEntity>().eq("yishengzhanghao", xinliyisheng.getYishengzhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		xinliyisheng.setId(uId);
        xinliyishengService.insert(xinliyisheng);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        XinliyishengEntity u = xinliyishengService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	XinliyishengEntity u = xinliyishengService.selectOne(new EntityWrapper<XinliyishengEntity>().eq("yishengzhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setYishengmima("123456");
        xinliyishengService.updateById(u);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XinliyishengEntity xinliyisheng,
		HttpServletRequest request){
        EntityWrapper<XinliyishengEntity> ew = new EntityWrapper<XinliyishengEntity>();

		PageUtils page = xinliyishengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xinliyisheng), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XinliyishengEntity xinliyisheng, 
		HttpServletRequest request){
        EntityWrapper<XinliyishengEntity> ew = new EntityWrapper<XinliyishengEntity>();

		PageUtils page = xinliyishengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xinliyisheng), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XinliyishengEntity xinliyisheng){
       	EntityWrapper<XinliyishengEntity> ew = new EntityWrapper<XinliyishengEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xinliyisheng, "xinliyisheng")); 
        return R.ok().put("data", xinliyishengService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XinliyishengEntity xinliyisheng){
        EntityWrapper< XinliyishengEntity> ew = new EntityWrapper< XinliyishengEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xinliyisheng, "xinliyisheng")); 
		XinliyishengView xinliyishengView =  xinliyishengService.selectView(ew);
		return R.ok("查询心理医生成功").put("data", xinliyishengView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XinliyishengEntity xinliyisheng = xinliyishengService.selectById(id);
		xinliyisheng = xinliyishengService.selectView(new EntityWrapper<XinliyishengEntity>().eq("id", id));
        return R.ok().put("data", xinliyisheng);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XinliyishengEntity xinliyisheng = xinliyishengService.selectById(id);
		xinliyisheng = xinliyishengService.selectView(new EntityWrapper<XinliyishengEntity>().eq("id", id));
        return R.ok().put("data", xinliyisheng);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XinliyishengEntity xinliyisheng, HttpServletRequest request){
        if(xinliyishengService.selectCount(new EntityWrapper<XinliyishengEntity>().eq("yishengzhanghao", xinliyisheng.getYishengzhanghao()))>0) {
            return R.error("医生账号已存在");
        }
    	xinliyisheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xinliyisheng);
    	XinliyishengEntity u = xinliyishengService.selectOne(new EntityWrapper<XinliyishengEntity>().eq("yishengzhanghao", xinliyisheng.getYishengzhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		xinliyisheng.setId(new Date().getTime());
        xinliyishengService.insert(xinliyisheng);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XinliyishengEntity xinliyisheng, HttpServletRequest request){
        if(xinliyishengService.selectCount(new EntityWrapper<XinliyishengEntity>().eq("yishengzhanghao", xinliyisheng.getYishengzhanghao()))>0) {
            return R.error("医生账号已存在");
        }
    	xinliyisheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xinliyisheng);
    	XinliyishengEntity u = xinliyishengService.selectOne(new EntityWrapper<XinliyishengEntity>().eq("yishengzhanghao", xinliyisheng.getYishengzhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		xinliyisheng.setId(new Date().getTime());
        xinliyishengService.insert(xinliyisheng);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XinliyishengEntity xinliyisheng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xinliyisheng);
        xinliyishengService.updateById(xinliyisheng);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<XinliyishengEntity> list = new ArrayList<XinliyishengEntity>();
        for(Long id : ids) {
            XinliyishengEntity xinliyisheng = xinliyishengService.selectById(id);
            xinliyisheng.setSfsh(sfsh);
            xinliyisheng.setShhf(shhf);
            list.add(xinliyisheng);
        }
        xinliyishengService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xinliyishengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
