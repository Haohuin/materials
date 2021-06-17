package com.ethan.bus.service.impl;

import com.ethan.bus.entity.Goods;
import com.ethan.bus.entity.Inport;
import com.ethan.bus.mapper.GoodsMapper;
import com.ethan.bus.mapper.InportMapper;
import com.ethan.bus.service.InportService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ethan
 * @since 2021-03-07
 */
@Service
@Transactional
public class InportServiceImpl extends ServiceImpl<InportMapper, Inport> implements InportService {
    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * 保存物资入库
     * @param entity
     * @return
     */
    @Override
    public boolean save(Inport entity) {
        //根据物资ID查询物资
        Goods goods = goodsMapper.selectById(entity.getGoodsid());
        goods.setNumber(goods.getNumber()+entity.getNumber());
        goodsMapper.updateById(goods);
        //保存入库信息
        return super.save(entity);
    }

    /**
     * 更新物资入库
     * @param entity
     * @return
     */
    @Override
    public boolean updateById(Inport entity) {
        //根据入库ID查询入库信息
        Inport inport = baseMapper.selectById(entity.getId());
        //根据物资ID查询物资信息
        Goods goods = goodsMapper.selectById(entity.getGoodsid());
        //库存算法  当前库存-入库单修改之前的数量+修改之后的数量
        goods.setNumber(goods.getNumber()-inport.getNumber()+entity.getNumber());
        goodsMapper.updateById(goods);
        //更新入库单
        return super.updateById(entity);
    }

    /**
     * 删除物资入库信息
     * @param id
     * @return
     */
    @Override
    public boolean removeById(Serializable id) {
        //根据入库ID查询入库信息
        Inport inport = baseMapper.selectById(id);
        //根据物资ID查询物资信息
        Goods goods = goodsMapper.selectById(inport.getGoodsid());
        //库存算法  当前库存-入库单数量
        goods.setNumber(goods.getNumber()-inport.getNumber());
        goodsMapper.updateById(goods);
        //更新物资的数量
        return super.removeById(id);
    }
}
