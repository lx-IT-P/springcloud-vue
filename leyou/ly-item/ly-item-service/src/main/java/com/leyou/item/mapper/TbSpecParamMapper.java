package com.leyou.item.mapper;

import com.leyou.item.pojo.TbSpecParam;
import com.leyou.item.pojo.TbSpecParamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSpecParamMapper {
    long countByExample(TbSpecParamExample example);

    int deleteByExample(TbSpecParamExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbSpecParam record);

    int insertSelective(TbSpecParam record);

    List<TbSpecParam> selectByExample(TbSpecParamExample example);

    TbSpecParam selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbSpecParam record, @Param("example") TbSpecParamExample example);

    int updateByExample(@Param("record") TbSpecParam record, @Param("example") TbSpecParamExample example);

    int updateByPrimaryKeySelective(TbSpecParam record);

    int updateByPrimaryKey(TbSpecParam record);
}