package com.frontend.web.dao;

import com.frontend.web.bo.TdViewPage;
import com.frontend.web.bo.TdViewPageCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TdViewPageMapper {
    int countByExample(TdViewPageCriteria example);

    int deleteByExample(TdViewPageCriteria example);

    int deleteByPrimaryKey(Long pageId);

    int insert(TdViewPage record);

    int insertSelective(TdViewPage record);

    List<TdViewPage> selectByExample(TdViewPageCriteria example);

    TdViewPage selectByPrimaryKey(Long pageId);

    int updateByExampleSelective(@Param("record") TdViewPage record, @Param("example") TdViewPageCriteria example);

    int updateByExample(@Param("record") TdViewPage record, @Param("example") TdViewPageCriteria example);

    int updateByPrimaryKeySelective(TdViewPage record);

    int updateByPrimaryKey(TdViewPage record);
}