package com.atguigu.gmall.front.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.front.fein.CategoryFeinClient;
import com.atguigu.gmall.model.vo.CategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    CategoryFeinClient categoryFeinClient;

    @GetMapping("/")
    public String indexPage(Model model){

        Result<List<CategoryVo>> categorys = categoryFeinClient.getCategorys();
        List<CategoryVo> result = categorys.getData();
        model.addAttribute("list",result);
        return ("index/index");
    }
}
