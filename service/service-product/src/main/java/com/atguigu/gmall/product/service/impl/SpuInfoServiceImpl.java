package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.model.product.SpuImage;
import com.atguigu.gmall.model.product.SpuInfo;
import com.atguigu.gmall.model.product.SpuSaleAttr;
import com.atguigu.gmall.model.product.SpuSaleAttrValue;
import com.atguigu.gmall.product.service.SpuImageService;
import com.atguigu.gmall.product.service.SpuSaleAttrService;
import com.atguigu.gmall.product.service.SpuSaleAttrValueService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.gmall.product.service.SpuInfoService;
import com.atguigu.gmall.product.mapper.SpuInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Administrator
* @description 针对表【spu_info(商品表)】的数据库操作Service实现
* @createDate 2023-12-18 21:15:40
*/
@Service
public class SpuInfoServiceImpl extends ServiceImpl<SpuInfoMapper, SpuInfo>
    implements SpuInfoService{

    @Autowired
    SpuImageService spuImageService;
    @Autowired
    SpuSaleAttrService spuSaleAttrService;
    @Autowired
    SpuSaleAttrValueService spuSaleAttrValueService;

    @Override
    public void saveSpuInfo(SpuInfo spuInfo) {
        save(spuInfo);
        Long spuInfoId = spuInfo.getId();

        List<SpuImage> spuImageList = spuInfo.getSpuImageList();
        for (SpuImage image:spuImageList){
            image.setSpuId(spuInfoId);
        }
        spuImageService.saveBatch(spuImageList);

        List<SpuSaleAttr> spuSaleAttrList = spuInfo.getSpuSaleAttrList();
        for (SpuSaleAttr spuSaleAttr:spuSaleAttrList){
            spuSaleAttr.setSpuId(spuInfoId);
            spuSaleAttrService.save(spuSaleAttr);

            List<SpuSaleAttrValue> spuSaleAttrValueList = spuSaleAttr.getSpuSaleAttrValueList();
            for (SpuSaleAttrValue value:spuSaleAttrValueList){
                value.setSpuId(spuInfoId);
                value.setSaleAttrName(spuSaleAttr.getSaleAttrName());
                spuSaleAttrValueService.save(value);
            }
        }
    }
}




