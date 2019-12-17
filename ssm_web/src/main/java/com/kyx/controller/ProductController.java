package com.kyx.controller;

import com.kyx.pojo.IProduct;
import com.kyx.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;
    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView();
        List<IProduct> all = productService.findAll();
        modelAndView.addObject("productList",all);
        modelAndView.setViewName("product-list");
        return modelAndView;
    }

 /*   @RequestMapping("/findAll")
    public String findAll(Model model) {
        System.out.println("表现层mvc测试 查询所有账户");
        List<IProduct> list = productService.findAll();
        model.addAttribute("productList", list);
        return "product-list";
    }*/
    /**
     * 添加产品
     */
    @RequestMapping("/save")
    public String save(IProduct product){
        productService.save(product);
        return "redirect:findAll";
    }

}
