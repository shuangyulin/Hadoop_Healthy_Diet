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

import com.entity.ForumreportEntity;
import com.entity.view.ForumreportView;

import com.service.ForumreportService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 社区交流举报
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-15 10:59:39
 */
@RestController
@RequestMapping("/forumreport")
public class ForumreportController {
    @Autowired
    private ForumreportService forumreportService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ForumreportEntity forumreport,
		HttpServletRequest request){
        if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
            forumreport.setUserid((Long)request.getSession().getAttribute("userId"));
        }
        //设置查询条件
        EntityWrapper<ForumreportEntity> ew = new EntityWrapper<ForumreportEntity>();


        //查询结果
		PageUtils page = forumreportService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, forumreport), params), params));
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
    public R list(@RequestParam Map<String, Object> params,ForumreportEntity forumreport, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ForumreportEntity> ew = new EntityWrapper<ForumreportEntity>();

        //查询结果
		PageUtils page = forumreportService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, forumreport), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ForumreportEntity forumreport){
       	EntityWrapper<ForumreportEntity> ew = new EntityWrapper<ForumreportEntity>();
      	ew.allEq(MPUtil.allEQMapPre( forumreport, "forumreport")); 
        return R.ok().put("data", forumreportService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ForumreportEntity forumreport){
        EntityWrapper< ForumreportEntity> ew = new EntityWrapper< ForumreportEntity>();
 		ew.allEq(MPUtil.allEQMapPre( forumreport, "forumreport")); 
		ForumreportView forumreportView =  forumreportService.selectView(ew);
		return R.ok("查询社区交流举报成功").put("data", forumreportView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ForumreportEntity forumreport = forumreportService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(forumreport,deSens);
        return R.ok().put("data", forumreport);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ForumreportEntity forumreport = forumreportService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(forumreport,deSens);
        return R.ok().put("data", forumreport);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ForumreportEntity forumreport, HttpServletRequest request){
        //ValidatorUtils.validateEntity(forumreport);
    	forumreport.setUserid((Long)request.getSession().getAttribute("userId"));
        forumreportService.insert(forumreport);
        return R.ok().put("data",forumreport.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ForumreportEntity forumreport, HttpServletRequest request){
        //ValidatorUtils.validateEntity(forumreport);
        forumreportService.insert(forumreport);
        return R.ok().put("data",forumreport.getId());
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        ForumreportEntity forumreport = forumreportService.selectOne(new EntityWrapper<ForumreportEntity>().eq("", username));
        return R.ok().put("data", forumreport);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody ForumreportEntity forumreport, HttpServletRequest request){
        //ValidatorUtils.validateEntity(forumreport);
        //全部更新
        forumreportService.updateById(forumreport);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        forumreportService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,ForumreportEntity forumreport, HttpServletRequest request,String pre){
        EntityWrapper<ForumreportEntity> ew = new EntityWrapper<ForumreportEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
        // 组装参数
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");

		PageUtils page = forumreportService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, forumreport), params), params));
        return R.ok().put("data", page);
    }








}
