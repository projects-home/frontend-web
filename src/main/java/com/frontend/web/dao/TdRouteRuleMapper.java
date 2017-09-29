package com.frontend.web.dao;

import com.frontend.web.bo.TdRouteRule;
import com.frontend.web.bo.TdRouteRuleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TdRouteRuleMapper {
    int countByExample(TdRouteRuleCriteria example);

    int deleteByExample(TdRouteRuleCriteria example);

    int deleteByPrimaryKey(Long routeId);

    int insert(TdRouteRule record);

    int insertSelective(TdRouteRule record);

    List<TdRouteRule> selectByExample(TdRouteRuleCriteria example);

    TdRouteRule selectByPrimaryKey(Long routeId);

    int updateByExampleSelective(@Param("record") TdRouteRule record, @Param("example") TdRouteRuleCriteria example);

    int updateByExample(@Param("record") TdRouteRule record, @Param("example") TdRouteRuleCriteria example);

    int updateByPrimaryKeySelective(TdRouteRule record);

    int updateByPrimaryKey(TdRouteRule record);
}