package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.EshianyycfEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.EshianyycfVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.EshianyycfView;


/**
 * 营养成份
 *
 * @author 
 * @email 
 * @date 2025-04-15 10:59:38
 */
public interface EshianyycfService extends IService<EshianyycfEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<EshianyycfVO> selectListVO(Wrapper<EshianyycfEntity> wrapper);
   	
   	EshianyycfVO selectVO(@Param("ew") Wrapper<EshianyycfEntity> wrapper);
   	
   	List<EshianyycfView> selectListView(Wrapper<EshianyycfEntity> wrapper);
   	
   	EshianyycfView selectView(@Param("ew") Wrapper<EshianyycfEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<EshianyycfEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<EshianyycfEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<EshianyycfEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<EshianyycfEntity> wrapper);

    List<Map<String, Object>> nengliangSectionStat(Map<String, Object> params,Wrapper<EshianyycfEntity> wrapper);


}

