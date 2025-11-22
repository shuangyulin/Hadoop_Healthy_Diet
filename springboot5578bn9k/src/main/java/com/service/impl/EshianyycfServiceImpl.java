package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.EshianyycfDao;
import com.entity.EshianyycfEntity;
import com.service.EshianyycfService;
import com.entity.vo.EshianyycfVO;
import com.entity.view.EshianyycfView;

@Service("eshianyycfService")
public class EshianyycfServiceImpl extends ServiceImpl<EshianyycfDao, EshianyycfEntity> implements EshianyycfService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<EshianyycfEntity> page = this.selectPage(
                new Query<EshianyycfEntity>(params).getPage(),
                new EntityWrapper<EshianyycfEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<EshianyycfEntity> wrapper) {
		  Page<EshianyycfView> page =new Query<EshianyycfView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<EshianyycfVO> selectListVO(Wrapper<EshianyycfEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public EshianyycfVO selectVO(Wrapper<EshianyycfEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<EshianyycfView> selectListView(Wrapper<EshianyycfEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public EshianyycfView selectView(Wrapper<EshianyycfEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<EshianyycfEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<EshianyycfEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<EshianyycfEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> nengliangSectionStat(Map<String, Object> params, Wrapper<EshianyycfEntity> wrapper) {
        return baseMapper.nengliangSectionStat(params, wrapper);
    }



}
