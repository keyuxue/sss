package com.kyx.controller;

import com.github.pagehelper.PageInfo;
import com.kyx.pojo.IProduct;
import com.kyx.pojo.Orders;
import com.kyx.service.IOrdersService;
import com.kyx.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private IOrdersService iOrdersService;
 /*   @RequestMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView();
        List<Orders> ordersList = iOrdersService.findAll();
        modelAndView.addObject("ordersList",ordersList);
        modelAndView.setViewName("orders-list");
        return modelAndView;
    }*/

    /**
     * 分页显示
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "4") int size) {
        ModelAndView modelAndView = new ModelAndView();
        List<Orders> list = iOrdersService.findAll(page, size);
        //PageInfo就是一个分页bean
        PageInfo pageInfo = new PageInfo(list);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("orders-page-list");
        return modelAndView;
    }

    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name = "id", required = true) String ordersId) {
        ModelAndView mv = new ModelAndView();
        Orders orders = iOrdersService.findById(ordersId);
        return mv;
    }
}
