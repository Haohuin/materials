package com.ethan.bus.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ethan.bus.entity.Goods;
import com.ethan.bus.entity.Inport;
import com.ethan.bus.entity.Provider;
import com.ethan.bus.service.GoodsService;
import com.ethan.bus.service.InportService;
import com.ethan.bus.service.ProviderService;
import com.ethan.bus.vo.InportVo;
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
@RequestMapping("inport")
public class InportController {
    @Autowired
    private InportService inportService;

    @Autowired
    private ProviderService providerService;

    @Autowired
    private GoodsService goodsService;

    /**
     * 查询物资入库
     * @param inportVo
     * @return
     */
    @RequestMapping("loadAllInport")
    public DataGridView loadAllInport(InportVo inportVo){
        IPage<Inport> page = new Page<Inport>(inportVo.getPage(),inportVo.getLimit());
        QueryWrapper<Inport> queryWrapper = new QueryWrapper<Inport>();
        //对供应商进行查询
        queryWrapper.eq(inportVo.getProviderid()!=null&&inportVo.getProviderid()!=0,"providerid",inportVo.getProviderid());
        //对物资进行查询
        queryWrapper.eq(inportVo.getGoodsid()!=null&&inportVo.getGoodsid()!=0,"goodsid",inportVo.getGoodsid());
        //对时间进行查询要求大于开始时间小于结束时间
        queryWrapper.ge(inportVo.getStartTime()!=null,"inporttime",inportVo.getStartTime());
        queryWrapper.le(inportVo.getEndTime()!=null,"inporttime",inportVo.getEndTime());
        //通过入库时间对物资进行排序
        queryWrapper.orderByDesc("inporttime");
        IPage<Inport> page1 = inportService.page(page, queryWrapper);
        List<Inport> records = page1.getRecords();
        for (Inport inport : records) {
            Provider provider = providerService.getById(inport.getProviderid());
            if (provider!=null){
                //设置供应商姓名
                inport.setProvidername(provider.getProvidername());
            }
            Goods goods = goodsService.getById(inport.getGoodsid());
            if (goods!=null){
                //设置物资名称
                inport.setGoodsname(goods.getGoodsname());
                //设置物资规格
                inport.setUnit(goods.getUnit());
            }
        }
        return new DataGridView(page1.getTotal(),page1.getRecords());
    }


    /**
     * 添加入库物资
     * @param inportVo
     * @return
     */
    @RequestMapping("addInport")
    public ResultObj addInport(InportVo inportVo){
        try {
            //获得当前系统用户
            User user = (User) WebUtils.getSession().getAttribute("user");
            //设置操作人
            inportVo.setOperator(user.getName());
            //设置入库时间
            inportVo.setInporttime(new Date());
            inportService.save(inportVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 更新入库物资
     * @param inportVo
     * @return
     */
    @RequestMapping("updateInport")
    public ResultObj updateInport(InportVo inportVo){
        try {
            inportService.updateById(inportVo);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }

    }

    /**
     * 删除入库物资
     * @param id
     * @return
     */
    @RequestMapping("deleteInport")
    public ResultObj deleteInport(Integer id){
        try {
            inportService.removeById(id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

}

