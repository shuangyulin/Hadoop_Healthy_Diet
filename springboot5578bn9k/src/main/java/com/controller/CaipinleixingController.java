package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import com.utils.ValidatorUtils;
import com.utils.DeSensUtil;
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
import com.annotation.IgnoreAuth;

import com.entity.CaipinleixingEntity;
import com.entity.view.CaipinleixingView;

import com.service.CaipinleixingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 菜品类型
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-15 10:59:38
 */
@RestController
@RequestMapping("/caipinleixing")
public class CaipinleixingController {
    @Autowired
    private CaipinleixingService caipinleixingService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,CaipinleixingEntity caipinleixing,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<CaipinleixingEntity> ew = new EntityWrapper<CaipinleixingEntity>();


        //查询结果
		PageUtils page = caipinleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, caipinleixing), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,CaipinleixingEntity caipinleixing, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<CaipinleixingEntity> ew = new EntityWrapper<CaipinleixingEntity>();

        //查询结果
		PageUtils page = caipinleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, caipinleixing), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( CaipinleixingEntity caipinleixing){
       	EntityWrapper<CaipinleixingEntity> ew = new EntityWrapper<CaipinleixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( caipinleixing, "caipinleixing")); 
        return R.ok().put("data", caipinleixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(CaipinleixingEntity caipinleixing){
        EntityWrapper< CaipinleixingEntity> ew = new EntityWrapper< CaipinleixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( caipinleixing, "caipinleixing")); 
		CaipinleixingView caipinleixingView =  caipinleixingService.selectView(ew);
		return R.ok("查询菜品类型成功").put("data", caipinleixingView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CaipinleixingEntity caipinleixing = caipinleixingService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(caipinleixing,deSens);
        return R.ok().put("data", caipinleixing);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CaipinleixingEntity caipinleixing = caipinleixingService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(caipinleixing,deSens);
        return R.ok().put("data", caipinleixing);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CaipinleixingEntity caipinleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(caipinleixing);
        caipinleixingService.insert(caipinleixing);
        return R.ok().put("data",caipinleixing.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody CaipinleixingEntity caipinleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(caipinleixing);
        caipinleixingService.insert(caipinleixing);
        return R.ok().put("data",caipinleixing.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody CaipinleixingEntity caipinleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(caipinleixing);
        //全部更新
        caipinleixingService.updateById(caipinleixing);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        caipinleixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
