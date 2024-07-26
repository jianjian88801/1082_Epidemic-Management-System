package com.dao;

import com.entity.QuezhenhuanzheEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.QuezhenhuanzheView;

/**
 * 确诊患者 Dao 接口
 *
 * @author 
 */
public interface QuezhenhuanzheDao extends BaseMapper<QuezhenhuanzheEntity> {

   List<QuezhenhuanzheView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
