package com.leyou.item.mapper;

import com.leyou.item.pojo.TbPayLog;
import com.leyou.item.pojo.TbPayLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPayLogMapper {
    long countByExample(TbPayLogExample example);

    int deleteByExample(TbPayLogExample example);

    int deleteByPrimaryKey(Long orderId);

    int insert(TbPayLog record);

    int insertSelective(TbPayLog record);

    List<TbPayLog> selectByExample(TbPayLogExample example);

    TbPayLog selectByPrimaryKey(Long orderId);

    int updateByExampleSelective(@Param("record") TbPayLog record, @Param("example") TbPayLogExample example);

    int updateByExample(@Param("record") TbPayLog record, @Param("example") TbPayLogExample example);

    int updateByPrimaryKeySelective(TbPayLog record);

    int updateByPrimaryKey(TbPayLog record);
}