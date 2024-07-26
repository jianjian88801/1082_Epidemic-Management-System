package com.dao;

import com.entity.SiwanghuanzheEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.SiwanghuanzheView;

/**
 * 死亡患者 Dao 接口
 *
 * @author 
 */
public interface SiwanghuanzheDao extends BaseMapper<SiwanghuanzheEntity> {

   List<SiwanghuanzheView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
