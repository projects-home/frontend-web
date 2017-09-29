package com.frontend.web.dao;

import com.frontend.web.bo.TdChartDataRule;
import com.frontend.web.bo.TdChartDataRuleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TdChartDataRuleMapper {
    int countByExample(TdChartDataRuleCriteria example);

    int deleteByExample(TdChartDataRuleCriteria example);

    int deleteByPrimaryKey(Long ruleId);

    int insert(TdChartDataRule record);

    int insertSelective(TdChartDataRule record);

    List<TdChartDataRule> selectByExample(TdChartDataRuleCriteria example);

    TdChartDataRule selectByPrimaryKey(Long ruleId);

    int updateByExampleSelective(@Param("record") TdChartDataRule record, @Param("example") TdChartDataRuleCriteria example);

    int updateByExample(@Param("record") TdChartDataRule record, @Param("example") TdChartDataRuleCriteria example);

    int updateByPrimaryKeySelective(TdChartDataRule record);

    int updateByPrimaryKey(TdChartDataRule record);
}