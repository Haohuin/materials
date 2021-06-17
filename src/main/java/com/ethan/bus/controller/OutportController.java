package com.ethan.bus.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ethan.bus.entity.Goods;
import com.ethan.bus.entity.Outport;
import com.ethan.bus.entity.Provider;
import com.ethan.bus.service.GoodsService;
import com.ethan.bus.service.OutportService;
import com.ethan.bus.service.ProviderService;
import com.ethan.bus.vo.InportVo;
import com.ethan.bus.vo.OutportVo;
import com.ethan.sys.common.DataGridView;
import com.ethan.sys.common.ResultObj;
import com.ethan.sys.common.WebUtils;
import com.ethan.sys.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ethan
 * @since 2021-03-07
 */
@RestController
@RequestMapping("outport")
public class OutportController {
    @Autowired
    private OutportService outportService;

    @Autowired
    private ProviderService providerService;

    @Autowired
    private GoodsService goodsService;

    /**
     * 查询物资出库
     * @param outportVo
     * @return
     */
    @RequestMapping("loadAllOutport")
    public DataGridView loadAllOuport(OutportVo outportVo){
        IPage<Outport> page = new Page<Outport>(outportVo.getPage(),outportVo.getLimit());
        QueryWrapper<Outport> queryWrapper = new QueryWrapper<Outport>();
        //对供应商进行查询
        queryWrapper.eq(outportVo.getProviderid()!=null&&outportVo.getProviderid()!=0,"providerid",outportVo.getProviderid());
        //对物资进行查询
        queryWrapper.eq(outportVo.getGoodsid()!=null&&outportVo.getGoodsid()!=0,"goodsid",outportVo.getGoodsid());
        //对时间进行查询要求大于开始时间小于结束时间
        queryWrapper.ge(outportVo.getStartTime()!=null,"outporttime",outportVo.getStartTime());
        queryWrapper.le(outportVo.getEndTime()!=null,"outporttime",outportVo.getEndTime());
        //通过入库时间对物资进行排序
        queryWrapper.orderByDesc("outporttime");
        IPage<Outport> page1 = outportService.page(page, queryWrapper);
        List<Outport> records = page1.getRecords();
        for (Outport ouport : records) {
            Provider provider = providerService.getById(ouport.getProviderid());
            if (provider!=null){
                //设置供应商姓名
                ouport.setProvidername(provider.getProvidername());
            }
            Goods goods = goodsService.getById(ouport.getGoodsid());
            if (goods!=null){
                //设置物资名称
                ouport.setGoodsname(goods.getGoodsname());
                //设置物资规格
                ouport.setUnit(goods.getUnit());
            }
        }
        return new DataGridView(page1.getTotal(),page1.getRecords());
    }

    /**
     * 删除出库信息
     * @param id
     * @return
     */
    @RequestMapping("deleteOutport")
    public ResultObj deleteOutport(Integer id){
        try {
            outportService.removeById(id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 更新出库物资
     * @param outportVo
     * @return
     */
    @RequestMapping("updateOutport")
    public ResultObj updateOutport(OutportVo outportVo){
        try {
            outportService.updateById(outportVo);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }

    }

    /**
     * 添加退货信息
     * @param id    进货单ID
     * @param number    出库数量
     * @param remark    备注
     * @return
     */
    @RequestMapping("addOutport")
    public ResultObj addOutport(Integer id,Integer number,String remark){
        try {
            outportService.addOutport(id,number,remark);
            return ResultObj.OUTPORT_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.OUTPORT_ERROR;
        }
    }
}

