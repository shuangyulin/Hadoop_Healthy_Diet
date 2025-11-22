package com.dao;

import com.entity.CaipinleixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.CaipinleixingVO;
import com.entity.view.CaipinleixingView;


/**
 * 菜品类型
 * 
 * @author 
 * @email 
 * @date 2025-04-15 10:59:38
 */
public interface CaipinleixingDao extends BaseMapper<CaipinleixingEntity> {
	
	List<CaipinleixingVO> selectListVO(@Param("ew") Wrapper<CaipinleixingEntity> wrapper);
	
	CaipinleixingVO selectVO(@Param("ew") Wrapper<CaipinleixingEntity> wrapper);
	
	List<CaipinleixingView> selectListView(@Param("ew") Wrapper<CaipinleixingEntity> wrapper);

	List<CaipinleixingView> selectListView(Pagination page,@Param("ew") Wrapper<CaipinleixingEntity> wrapper);

	
	CaipinleixingView selectView(@Param("ew") Wrapper<CaipinleixingEntity> wrapper);
	

}
