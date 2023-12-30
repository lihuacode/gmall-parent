package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.BaseAttrInfo;
import com.atguigu.gmall.model.product.BaseAttrValue;
import com.atguigu.gmall.product.service.BaseAttrInfoService;
import com.atguigu.gmall.product.service.BaseAttrValueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/admin/product")
@RestController
public class BaseAttrController {

    @Autowired
    BaseAttrInfoService baseAttrInfoService;

    @Autowired
    BaseAttrValueService baseAttrValueService;

    /**
     * 查询分类下所有属性名和值
     * @param c1id
     * @param c2id
     * @param c3id
     * @return
     */
    @GetMapping("/attrInfoList/{c1id}/{c2id}/{c3id}")
    public Result attrInfoList(@PathVariable ("c1id") Long c1id,
                               @PathVariable("c2id") Long c2id,
                               @PathVariable("c3id") Long c3id){
        List<BaseAttrInfo> infos =  baseAttrInfoService.getBaseAttrInfoWithValue(c1id,c2id,c3id);
        return Result.ok(infos);
    }

    /**
     * 保存平台属性
     * @param baseAttrInfo
     * @return
     */
    @PostMapping("/saveAttrInfo")
    public Result saveAttrInfo(@RequestBody BaseAttrInfo baseAttrInfo){

        log.info("保存/修改平台属性:"+baseAttrInfo);
        if (baseAttrInfo.getId() == null){
            baseAttrInfoService.saveAttrInfoAndValue(baseAttrInfo);
        }else {
            baseAttrInfoService.updateAttrInfoAndValue(baseAttrInfo);
        }

        return Result.ok();
    }

    @GetMapping("/getAttrValueList/{attrId}")
    public Result getAttrValueList(@PathVariable("attrId") Long attrId){
        List<BaseAttrValue> baseAttrValues = baseAttrValueService.getBaseAttrValueList(attrId);
        return Result.ok(baseAttrValues);
    }
}
