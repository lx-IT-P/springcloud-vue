package com.leyou.item.mapper;

import com.leyou.item.pojo.Cid3;
import com.leyou.item.pojo.Cid3Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Cid3Mapper {
    long countByExample(Cid3Example example);

    int deleteByExample(Cid3Example example);

    int insert(Cid3 record);

    int insertSelective(Cid3 record);

    List<Cid3> selectByExample(Cid3Example example);

    int updateByExampleSelective(@Param("record") Cid3 record, @Param("example") Cid3Example example);

    int updateByExample(@Param("record") Cid3 record, @Param("example") Cid3Example example);
}