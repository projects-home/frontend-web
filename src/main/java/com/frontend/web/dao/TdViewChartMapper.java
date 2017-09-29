package com.frontend.web.dao;

import com.frontend.web.bo.TdViewChart;
import com.frontend.web.bo.TdViewChartCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TdViewChartMapper {
    int countByExample(TdViewChartCriteria example);

    int deleteByExample(TdViewChartCriteria example);

    int deleteByPrimaryKey(Long chartId);

    int insert(TdViewChart record);

    int insertSelective(TdViewChart record);

    List<TdViewChart> selectByExample(TdViewChartCriteria example);

    TdViewChart selectByPrimaryKey(Long chartId);

    int updateByExampleSelective(@Param("record") TdViewChart record, @Param("example") TdViewChartCriteria example);

    int updateByExample(@Param("record") TdViewChart record, @Param("example") TdViewChartCriteria example);

    int updateByPrimaryKeySelective(TdViewChart record);

    int updateByPrimaryKey(TdViewChart record);
}