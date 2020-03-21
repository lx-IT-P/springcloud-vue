package com.leyou.item.mapper;

import com.leyou.item.pojo.TbStock;
import com.leyou.item.pojo.TbStockExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbStockMapper {
    long countByExample(TbStockExample example);

    int deleteByExample(TbStockExample example);

    int deleteByPrimaryKey(Long skuId);

    int insert(TbStock record);

    int insertSelective(TbStock record);

    List<TbStock> selectByExample(TbStockExample example);

    TbStock selectByPrimaryKey(Long skuId);

    int updateByExampleSelective(@Param("record") TbStock record, @Param("example") TbStockExample example);

    int updateByExample(@Param("record") TbStock record, @Param("example") TbStockExample example);

    int updateByPrimaryKeySelective(TbStock record);

    int updateByPrimaryKey(TbStock record);
}