package com.dao;

import com.entity.EshianyycfEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.EshianyycfVO;
import com.entity.view.EshianyycfView;


/**
 * 营养成份
 * 
 * @author 
 * @email 
 * @date 2025-04-15 10:59:38
 */
public interface EshianyycfDao extends BaseMapper<EshianyycfEntity> {
	
	List<EshianyycfVO> selectListVO(@Param("ew") Wrapper<EshianyycfEntity> wrapper);
	
	EshianyycfVO selectVO(@Param("ew") Wrapper<EshianyycfEntity> wrapper);
	
	List<EshianyycfView> selectListView(@Param("ew") Wrapper<EshianyycfEntity> wrapper);

	List<EshianyycfView> selectListView(Pagination page,@Param("ew") Wrapper<EshianyycfEntity> wrapper);

	
	EshianyycfView selectView(@Param("ew") Wrapper<EshianyycfEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<EshianyycfEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<EshianyycfEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<EshianyycfEntity> wrapper);

    List<Map<String, Object>> nengliangSectionStat(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<EshianyycfEntity> wrapper);


}
