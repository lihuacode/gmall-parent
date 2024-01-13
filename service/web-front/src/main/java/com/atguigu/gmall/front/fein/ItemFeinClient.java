package com.atguigu.gmall.front.fein;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.vo.SkuDetailVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rpc/inner/item")
@RestController
public interface ItemFeinClient {

    @GetMapping("/sku/{skuId}")
    Result<SkuDetailVo> getSkuDetail(@PathVariable("skuId") Long skuId);
}
