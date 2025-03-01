package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ExamrecordEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ExamrecordView;


/**
 * 心理测试
 *
 * @author 
 * @email 
 * @date 2024-04-09 15:54:50
 */
public interface ExamrecordService extends IService<ExamrecordEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ExamrecordView> selectListView(Wrapper<ExamrecordEntity> wrapper);
   	
   	ExamrecordView selectView(@Param("ew") Wrapper<ExamrecordEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ExamrecordEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<ExamrecordEntity> wrapper);

}

