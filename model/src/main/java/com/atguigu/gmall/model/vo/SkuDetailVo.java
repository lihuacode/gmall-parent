package com.atguigu.gmall.model.vo;

import com.atguigu.gmall.model.product.SkuInfo;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class SkuDetailVo {
    private CategoryView categoryView;
    private SkuInfo skuInfo;
    private BigDecimal price;
    private Object spuSaleAttrList;
    private String valuesSkuJson;
}
