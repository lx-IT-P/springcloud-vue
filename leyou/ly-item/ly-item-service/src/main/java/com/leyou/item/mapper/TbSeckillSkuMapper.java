package com.leyou.item.mapper;

import com.leyou.item.pojo.TbSeckillSku;
import com.leyou.item.pojo.TbSeckillSkuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSeckillSkuMapper {
    long countByExample(TbSeckillSkuExample example);

    int deleteByExample(TbSeckillSkuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbSeckillSku record);

    int insertSelective(TbSeckillSku record);

    List<TbSeckillSku> selectByExample(TbSeckillSkuExample example);

    TbSeckillSku selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbSeckillSku record, @Param("example") TbSeckillSkuExample example);

    int updateByExample(@Param("record") TbSeckillSku record, @Param("example") TbSeckillSkuExample example);

    int updateByPrimaryKeySelective(TbSeckillSku record);

    int updateByPrimaryKey(TbSeckillSku record);
}