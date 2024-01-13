package com.atguigu.gmall.item.rpc;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.vo.SkuDetailVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rpc/inner/item")
public class ItemRpcController {

    @GetMapping("/sku/{skuId}")
    public Result<SkuDetailVo> getSkuDetail(@PathVariable("skuId") Long skuId){
        return Result.ok();
    }
}
