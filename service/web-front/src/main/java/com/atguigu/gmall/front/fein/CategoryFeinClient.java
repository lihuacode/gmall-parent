package com.atguigu.gmall.front.fein;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.vo.CategoryVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/rpc/inner/product")
@FeignClient("service-product")
public interface CategoryFeinClient {


    @GetMapping("/categorys/all")
    Result<List<CategoryVo>> getCategorys();
}
