package com.dao;

import com.entity.ForumreportEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ForumreportVO;
import com.entity.view.ForumreportView;


/**
 * 社区交流举报
 * 
 * @author 
 * @email 
 * @date 2025-04-15 10:59:39
 */
public interface ForumreportDao extends BaseMapper<ForumreportEntity> {
	
	List<ForumreportVO> selectListVO(@Param("ew") Wrapper<ForumreportEntity> wrapper);
	
	ForumreportVO selectVO(@Param("ew") Wrapper<ForumreportEntity> wrapper);
	
	List<ForumreportView> selectListView(@Param("ew") Wrapper<ForumreportEntity> wrapper);

	List<ForumreportView> selectListView(Pagination page,@Param("ew") Wrapper<ForumreportEntity> wrapper);

	
	ForumreportView selectView(@Param("ew") Wrapper<ForumreportEntity> wrapper);
	

}
