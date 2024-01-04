package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.SpuInfo;
import com.atguigu.gmall.product.service.SpuInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/product")
public class SpuController {

    @Autowired
    SpuInfoService spuInfoService;

    @GetMapping("/{page}/{limit}")
    public Result getSpuByCategorId(@PathVariable("page") Long page,
                                    @PathVariable("limit") Long limit,
                                    @RequestParam("category3Id") Long category3Id){
        Page<SpuInfo> spuInfoPage = new Page<>();
        QueryWrapper<SpuInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("category3_id",category3Id);
        Page<SpuInfo> spuInfo = spuInfoService.page(spuInfoPage, queryWrapper);
        return Result.ok(spuInfo);
    }

    @PostMapping("/saveSpuInfo")
    public Result saveSpuInfo(@RequestBody SpuInfo spuInfo){
        spuInfoService.saveSpuInfo(spuInfo);
        return Result.ok();
    }

}
