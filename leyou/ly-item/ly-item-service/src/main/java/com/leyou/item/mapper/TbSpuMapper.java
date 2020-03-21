package com.leyou.item.mapper;

import com.leyou.item.pojo.TbSpu;
import com.leyou.item.pojo.TbSpuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSpuMapper {
    long countByExample(TbSpuExample example);

    int deleteByExample(TbSpuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbSpu record);

    int insertSelective(TbSpu record);

    List<TbSpu> selectByExample(TbSpuExample example);

    TbSpu selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbSpu record, @Param("example") TbSpuExample example);

    int updateByExample(@Param("record") TbSpu record, @Param("example") TbSpuExample example);

    int updateByPrimaryKeySelective(TbSpu record);

    int updateByPrimaryKey(TbSpu record);
}