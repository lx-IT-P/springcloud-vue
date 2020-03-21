package com.leyou.item.mapper;

import com.leyou.item.pojo.TbOrderStatus;
import com.leyou.item.pojo.TbOrderStatusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbOrderStatusMapper {
    long countByExample(TbOrderStatusExample example);

    int deleteByExample(TbOrderStatusExample example);

    int deleteByPrimaryKey(Long orderId);

    int insert(TbOrderStatus record);

    int insertSelective(TbOrderStatus record);

    List<TbOrderStatus> selectByExample(TbOrderStatusExample example);

    TbOrderStatus selectByPrimaryKey(Long orderId);

    int updateByExampleSelective(@Param("record") TbOrderStatus record, @Param("example") TbOrderStatusExample example);

    int updateByExample(@Param("record") TbOrderStatus record, @Param("example") TbOrderStatusExample example);

    int updateByPrimaryKeySelective(TbOrderStatus record);

    int updateByPrimaryKey(TbOrderStatus record);
}