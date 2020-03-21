package com.leyou.item.mapper;

import com.leyou.item.pojo.TbSpuDetail;
import com.leyou.item.pojo.TbSpuDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSpuDetailMapper {
    long countByExample(TbSpuDetailExample example);

    int deleteByExample(TbSpuDetailExample example);

    int deleteByPrimaryKey(Long spuId);

    int insert(TbSpuDetail record);

    int insertSelective(TbSpuDetail record);

    List<TbSpuDetail> selectByExampleWithBLOBs(TbSpuDetailExample example);

    List<TbSpuDetail> selectByExample(TbSpuDetailExample example);

    TbSpuDetail selectByPrimaryKey(Long spuId);

    int updateByExampleSelective(@Param("record") TbSpuDetail record, @Param("example") TbSpuDetailExample example);

    int updateByExampleWithBLOBs(@Param("record") TbSpuDetail record, @Param("example") TbSpuDetailExample example);

    int updateByExample(@Param("record") TbSpuDetail record, @Param("example") TbSpuDetailExample example);

    int updateByPrimaryKeySelective(TbSpuDetail record);

    int updateByPrimaryKeyWithBLOBs(TbSpuDetail record);

    int updateByPrimaryKey(TbSpuDetail record);
}