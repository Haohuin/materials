package com.ethan.bus.service.impl;

import com.ethan.bus.entity.Goods;
import com.ethan.bus.mapper.GoodsMapper;
import com.ethan.bus.service.GoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

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
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
    @Override
    public boolean save(Goods entity) {
        return super.save(entity);
    }

    @Override
    public boolean removeById(Serializable id) {
        return super.removeById(id);
    }

    @Override
    public boolean updateById(Goods entity) {
        return super.updateById(entity);
    }

    @Override
    public Goods getById(Serializable id) {
        return super.getById(id);
    }

    @Override
    public void deleteGoodsById(Integer id) {
        //根据物资id删除物资入库信息
        this.getBaseMapper().deleteInportByGoodsId(id);
        //根据物资id删除物资出库信息
        this.getBaseMapper().deleteOutportByGoodsId(id);
        //删除物资信息
        this.removeById(id);
    }

    @Override
    public List<Goods> loadAllWarning() {
        List<Goods> goodsList = baseMapper.loadAllWarning();
        return goodsList;
    }
}
