package com.dao;

import com.entity.MiqiejiechuzheEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.MiqiejiechuzheView;

/**
 * 密切接触者 Dao 接口
 *
 * @author 
 */
public interface MiqiejiechuzheDao extends BaseMapper<MiqiejiechuzheEntity> {

   List<MiqiejiechuzheView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
