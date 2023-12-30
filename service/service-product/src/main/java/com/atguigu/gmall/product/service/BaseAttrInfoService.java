package com.atguigu.gmall.product.service;


import com.atguigu.gmall.model.product.BaseAttrInfo;
import com.atguigu.gmall.model.product.BaseAttrValue;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Administrator
* @description 针对表【base_attr_info(属性表)】的数据库操作Service
* @createDate 2023-12-18 21:15:39
*/
public interface BaseAttrInfoService extends IService<BaseAttrInfo> {

    List<BaseAttrInfo> getBaseAttrInfoWithValue(Long c1id, Long c2id, Long c3id);

    void saveAttrInfoAndValue(BaseAttrInfo baseAttrInfo);

    void updateAttrInfoAndValue(BaseAttrInfo baseAttrInfo);
}
