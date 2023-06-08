package com.Haggle.cloud.product.mapper;

import com.Haggle.cloud.product.model.CategoryBrand;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface CategoryBrandMapper {

	/**
	 * 根据品牌分类关联信息id删除品牌分类关联信息
	 *
	 * @param brandId
	 */
	void deleteByBrandId(@Param("brandId") Long brandId);

	/**
	 * 批量保存
	 * @param categoryBrandList
	 */
	void saveBatch(@Param("categoryBrandList") List<CategoryBrand> categoryBrandList);

	/**
	 * 根据品牌id获取关联的分类id
	 * @param brandId 品牌id
	 * @return 分类id列表
	 */
	List<Long> getCategoryIdsByBrandId(@Param("brandId") Long brandId);

	/**
	 * 根据品牌id和分类id列表删除关联信息
	 * @param brandId
	 * @param categoryIds
	 */
	void deleteByBrandIdAndCategoryIds(@Param("brandId") Long brandId, @Param("categoryIds") List<Long> categoryIds);
}
