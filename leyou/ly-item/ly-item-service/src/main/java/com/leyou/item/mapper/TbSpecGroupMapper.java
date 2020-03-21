package com.leyou.item.mapper;

import com.leyou.item.pojo.TbSpecGroup;
import com.leyou.item.pojo.TbSpecGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSpecGroupMapper {
    long countByExample(TbSpecGroupExample example);

    int deleteByExample(TbSpecGroupExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbSpecGroup record);

    int insertSelective(TbSpecGroup record);

    List<TbSpecGroup> selectByExample(TbSpecGroupExample example);

    TbSpecGroup selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbSpecGroup record, @Param("example") TbSpecGroupExample example);

    int updateByExample(@Param("record") TbSpecGroup record, @Param("example") TbSpecGroupExample example);

    int updateByPrimaryKeySelective(TbSpecGroup record);

    int updateByPrimaryKey(TbSpecGroup record);
}