package com.ethan.bus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 业务部分跳转
 * @author ethan
 */
@Controller
@RequestMapping("bus")
public class BusController {

    /**
     * 跳转到供应商管理页面
     * @return
     */
    @RequestMapping("toProviderManager")
    public String toProviderManager(){
        return "business/provider/providerManager";
    }

    /**
     * 跳转到物资管理页面
     * @return
     */
    @RequestMapping("toGoodsManager")
    public String toGoodsManager(){
        return "business/goods/goodsManager";
    }

    /**
     * 跳转到物资入库页面
     * @return
     */
    @RequestMapping("toInportManager")
    public String toInportManager(){
        return "business/inport/inportManager";
    }

    /**
     * 跳转到物资出库页面
     * @return
     */
    @RequestMapping("toOutportManager")
    public String toOutportManager(){
        return "business/outport/outportManager";
    }
}
