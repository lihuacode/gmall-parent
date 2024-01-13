package com.atguigu.gmall.front.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.front.fein.CategoryFeinClient;
import com.atguigu.gmall.front.fein.ItemFeinClient;
import com.atguigu.gmall.model.vo.SkuDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ItemController {

    @Autowired
    ItemFeinClient itemFeinClient;

    @GetMapping("/{skuId}.html")
    public String item(@PathVariable("skuId") Long skuId, Model model){

        Result<SkuDetailVo> skuDetail = itemFeinClient.getSkuDetail(skuId);
        SkuDetailVo data = skuDetail.getData();

        model.addAttribute("categoryView",data.getCategoryView());
        model.addAttribute("skuInfo",data.getSkuInfo());
        model.addAttribute("price",data.getPrice());
        model.addAttribute("spuSaleAttrList",data.getSpuSaleAttrList());
        model.addAttribute("valuesSkuJson",data.getValuesSkuJson());
        return "item/index";
    }
}
