package com.atguigu.gmall.product.service;


import com.atguigu.gmall.model.product.SkuInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Administrator
* @description 针对表【sku_info(库存单元表)】的数据库操作Service
* @createDate 2023-12-18 21:15:40
*/
public interface SkuInfoService extends IService<SkuInfo> {

    void saveSkuInfo(SkuInfo skuInfo);

    void upSku(Long skuId);

    void downSku(Long skuId);
}
