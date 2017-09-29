package com.frontend.web.dao;

import com.frontend.web.bo.TdViewArch;
import com.frontend.web.bo.TdViewArchCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TdViewArchMapper {
    int countByExample(TdViewArchCriteria example);

    int deleteByExample(TdViewArchCriteria example);

    int deleteByPrimaryKey(Long archId);

    int insert(TdViewArch record);

    int insertSelective(TdViewArch record);

    List<TdViewArch> selectByExample(TdViewArchCriteria example);

    TdViewArch selectByPrimaryKey(Long archId);

    int updateByExampleSelective(@Param("record") TdViewArch record, @Param("example") TdViewArchCriteria example);

    int updateByExample(@Param("record") TdViewArch record, @Param("example") TdViewArchCriteria example);

    int updateByPrimaryKeySelective(TdViewArch record);

    int updateByPrimaryKey(TdViewArch record);
}