package com.ethan.bus.service.impl;

import com.ethan.bus.entity.Goods;
import com.ethan.bus.entity.Inport;
import com.ethan.bus.entity.Outport;
import com.ethan.bus.mapper.GoodsMapper;
import com.ethan.bus.mapper.InportMapper;
import com.ethan.bus.mapper.OutportMapper;
import com.ethan.bus.service.OutportService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ethan.sys.common.WebUtils;
import com.ethan.sys.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ethan
 * @since 2021-03-07
 */
@Service
public class OutportServiceImpl extends ServiceImpl<OutportMapper, Outport> implements OutportService {
    @Autowired
    private InportMapper inportMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * @param id    入库单ID
     * @param number    出库数量
     * @param remark    备注
     */
    @Override
    public void addOutport(Integer id, Integer number, String remark) {
        //1.通过入库单ID查询出入库单信息
        Inport inport = inportMapper.selectById(id);
        //2.根据物资ID查询物资信息
        Goods goods = goodsMapper.selectById(inport.getGoodsid());
        //3.修改物资的数量     物资的数量-出库的数量
        goods.setNumber(goods.getNumber()-number);

        //修改入库的数量
        inport.setNumber(inport.getNumber()-number);
        inportMapper.updateById(inport);

        //4.进行修改
        goodsMapper.updateById(goods);

        //5.添加出库单信息
        Outport outport = new Outport();
        outport.setGoodsid(inport.getGoodsid());
        outport.setNumber(number);
        User user = (User) WebUtils.getSession().getAttribute("user");
        outport.setOperator(user.getName());

        outport.setOutporttime(new Date());
        outport.setRemarks(remark);
        outport.setProviderid(inport.getProviderid());
        getBaseMapper().insert(outport);
    }
}
