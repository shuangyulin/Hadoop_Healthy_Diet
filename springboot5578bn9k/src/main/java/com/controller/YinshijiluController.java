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

import com.entity.YinshijiluEntity;
import com.entity.view.YinshijiluView;

import com.service.YinshijiluService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 饮食记录
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-15 10:59:38
 */
@RestController
@RequestMapping("/yinshijilu")
public class YinshijiluController {
    @Autowired
    private YinshijiluService yinshijiluService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YinshijiluEntity yinshijilu,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date riqistart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date riqiend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			yinshijilu.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<YinshijiluEntity> ew = new EntityWrapper<YinshijiluEntity>();
        if(riqistart!=null) ew.ge("riqi", riqistart);
        if(riqiend!=null) ew.le("riqi", riqiend);


        //查询结果
		PageUtils page = yinshijiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yinshijilu), params), params));
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
    public R list(@RequestParam Map<String, Object> params,YinshijiluEntity yinshijilu, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date riqistart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date riqiend,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<YinshijiluEntity> ew = new EntityWrapper<YinshijiluEntity>();
        if(riqistart!=null) ew.ge("riqi", riqistart);
        if(riqiend!=null) ew.le("riqi", riqiend);

        //查询结果
		PageUtils page = yinshijiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yinshijilu), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YinshijiluEntity yinshijilu){
       	EntityWrapper<YinshijiluEntity> ew = new EntityWrapper<YinshijiluEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yinshijilu, "yinshijilu")); 
        return R.ok().put("data", yinshijiluService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YinshijiluEntity yinshijilu){
        EntityWrapper< YinshijiluEntity> ew = new EntityWrapper< YinshijiluEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yinshijilu, "yinshijilu")); 
		YinshijiluView yinshijiluView =  yinshijiluService.selectView(ew);
		return R.ok("查询饮食记录成功").put("data", yinshijiluView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YinshijiluEntity yinshijilu = yinshijiluService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(yinshijilu,deSens);
        return R.ok().put("data", yinshijilu);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YinshijiluEntity yinshijilu = yinshijiluService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(yinshijilu,deSens);
        return R.ok().put("data", yinshijilu);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YinshijiluEntity yinshijilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yinshijilu);
        yinshijiluService.insert(yinshijilu);
        return R.ok().put("data",yinshijilu.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YinshijiluEntity yinshijilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yinshijilu);
        yinshijiluService.insert(yinshijilu);
        return R.ok().put("data",yinshijilu.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YinshijiluEntity yinshijilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yinshijilu);
        //全部更新
        yinshijiluService.updateById(yinshijilu);
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<YinshijiluEntity> list = new ArrayList<YinshijiluEntity>();
        for(Long id : ids) {
            YinshijiluEntity yinshijilu = yinshijiluService.selectById(id);
            yinshijilu.setSfsh(sfsh);
            yinshijilu.setShhf(shhf);
            list.add(yinshijilu);
        }
        yinshijiluService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yinshijiluService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
