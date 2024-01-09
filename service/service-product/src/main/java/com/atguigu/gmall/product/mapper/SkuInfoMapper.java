package com.atguigu.gmall.product.mapper;


import com.atguigu.gmall.model.product.SkuInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import feign.Param;

/**
* @author Administrator
* @description 针对表【sku_info(库存单元表)】的数据库操作Mapper
* @createDate 2023-12-18 21:15:40
* @Entity com.atguigu.gmall.product.domain.SkuInfo
*/
public interface SkuInfoMapper extends BaseMapper<SkuInfo> {

    void updateSaleStatus(@Param("skuId") Long skuId,@Param("status") int status);
}




