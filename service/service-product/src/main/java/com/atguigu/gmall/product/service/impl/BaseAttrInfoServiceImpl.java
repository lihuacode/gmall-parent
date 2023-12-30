package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.model.product.BaseAttrInfo;
import com.atguigu.gmall.model.product.BaseAttrValue;
import com.atguigu.gmall.product.service.BaseAttrValueService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.gmall.product.service.BaseAttrInfoService;
import com.atguigu.gmall.product.mapper.BaseAttrInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

/**
* @author Administrator
* @description 针对表【base_attr_info(属性表)】的数据库操作Service实现
* @createDate 2023-12-18 21:15:39
*/
@Service
public class BaseAttrInfoServiceImpl extends ServiceImpl<BaseAttrInfoMapper, BaseAttrInfo>
    implements BaseAttrInfoService{

    @Autowired
    BaseAttrInfoMapper baseAttrInfoMapper;
    @Autowired
    BaseAttrValueService baseAttrValueService;
    @Override
    public List<BaseAttrInfo> getBaseAttrInfoWithValue(Long c1Id, Long c2Id, Long c3Id) {
        return baseAttrInfoMapper.getBaseAttrInfoWithValue(c1Id,c2Id,c3Id);
    }

    @Transactional
    @Override
    public void saveAttrInfoAndValue(BaseAttrInfo baseAttrInfo) {
        // 属性名信息保存
        baseAttrInfoMapper.insert(baseAttrInfo);
        // mybatis-plus会自动回填自增id到原来的javaBean
        Long id = baseAttrInfo.getId();

        // 属性信息保存
        List<BaseAttrValue> attrValueList = baseAttrInfo.getAttrValueList();
        for (BaseAttrValue value:attrValueList){
            value.setAttrId(id);
        }

        // 批量保存
        baseAttrValueService.saveBatch(attrValueList);
    }

    @Override
    public void updateAttrInfoAndValue(BaseAttrInfo baseAttrInfo) {
        // 修改属性名、分类、层级

        // 修改属性值
        ArrayList<Object> ids = new ArrayList<>();
        List<BaseAttrValue> attrValueList = baseAttrInfo.getAttrValueList();
        for (BaseAttrValue value:attrValueList){
            // 新增，没带id直接新增
            if (value.getId() == null){
                value.setAttrId(baseAttrInfo.getId());
                baseAttrValueService.save(value);
            }
            if (value.getId() != null){
                baseAttrValueService.updateById(value);
                ids.add(value.getId());
            }
        }

        if (ids.size() > 0){
            QueryWrapper<BaseAttrValue> deleteWrapper = new QueryWrapper<>();
            deleteWrapper.eq("attr_id",baseAttrInfo.getId());
            deleteWrapper.notIn("id",ids);
            baseAttrValueService.remove(deleteWrapper);
        }else {
            QueryWrapper<BaseAttrValue> deleteWrapper = new QueryWrapper<>();
            deleteWrapper.eq("attr_id",baseAttrInfo.getId());
            baseAttrValueService.remove(deleteWrapper);
        }
    }

}




