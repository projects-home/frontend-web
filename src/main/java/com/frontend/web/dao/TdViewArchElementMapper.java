package com.frontend.web.dao;

import com.frontend.web.bo.TdViewArchElement;
import com.frontend.web.bo.TdViewArchElementCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TdViewArchElementMapper {
    int countByExample(TdViewArchElementCriteria example);

    int deleteByExample(TdViewArchElementCriteria example);

    int deleteByPrimaryKey(Long elementId);

    int insert(TdViewArchElement record);

    int insertSelective(TdViewArchElement record);

    List<TdViewArchElement> selectByExample(TdViewArchElementCriteria example);

    TdViewArchElement selectByPrimaryKey(Long elementId);

    int updateByExampleSelective(@Param("record") TdViewArchElement record, @Param("example") TdViewArchElementCriteria example);

    int updateByExample(@Param("record") TdViewArchElement record, @Param("example") TdViewArchElementCriteria example);

    int updateByPrimaryKeySelective(TdViewArchElement record);

    int updateByPrimaryKey(TdViewArchElement record);
}