package com.atguigu.gmall.product.service;


import com.atguigu.gmall.model.product.BaseAttrValue;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Administrator
* @description 针对表【base_attr_value(属性值表)】的数据库操作Service
* @createDate 2023-12-18 21:15:39
*/
public interface BaseAttrValueService extends IService<BaseAttrValue> {


    List<BaseAttrValue> getBaseAttrValueList(Long attrId);
}
