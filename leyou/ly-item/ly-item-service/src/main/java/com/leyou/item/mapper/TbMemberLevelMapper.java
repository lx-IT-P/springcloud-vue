package com.leyou.item.mapper;

import com.leyou.item.pojo.TbMemberLevel;
import com.leyou.item.pojo.TbMemberLevelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbMemberLevelMapper {
    long countByExample(TbMemberLevelExample example);

    int deleteByExample(TbMemberLevelExample example);

    int insert(TbMemberLevel record);

    int insertSelective(TbMemberLevel record);

    List<TbMemberLevel> selectByExample(TbMemberLevelExample example);

    int updateByExampleSelective(@Param("record") TbMemberLevel record, @Param("example") TbMemberLevelExample example);

    int updateByExample(@Param("record") TbMemberLevel record, @Param("example") TbMemberLevelExample example);
}