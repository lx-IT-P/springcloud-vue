package com.leyou.item.mapper;

import com.leyou.item.pojo.TbCategoryBrand;
import com.leyou.item.pojo.TbCategoryBrandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbCategoryBrandMapper {
    long countByExample(TbCategoryBrandExample example);

    int deleteByExample(TbCategoryBrandExample example);

    int deleteByPrimaryKey(@Param("categoryId") Long categoryId, @Param("brandId") Long brandId);

    int insert(TbCategoryBrand record);

    int insertSelective(TbCategoryBrand record);

    List<TbCategoryBrand> selectByExample(TbCategoryBrandExample example);

    int updateByExampleSelective(@Param("record") TbCategoryBrand record, @Param("example") TbCategoryBrandExample example);

    int updateByExample(@Param("record") TbCategoryBrand record, @Param("example") TbCategoryBrandExample example);
}