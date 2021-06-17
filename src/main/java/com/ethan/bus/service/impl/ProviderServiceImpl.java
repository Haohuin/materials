package com.ethan.bus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ethan.bus.entity.Goods;
import com.ethan.bus.entity.Provider;
import com.ethan.bus.mapper.GoodsMapper;
import com.ethan.bus.mapper.ProviderMapper;
import com.ethan.bus.service.ProviderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class ProviderServiceImpl extends ServiceImpl<ProviderMapper, Provider> implements ProviderService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public void deleteProviderById(Integer id) {
        //根据供应商id删除物资出库信息
        this.getBaseMapper().deleteOutPortByProviderId(id);
        //根据供应商id删除物资入库信息
        this.getBaseMapper().deleteInportByProviderId(id);
        //根据供应商id删除物资
        this.getBaseMapper().deleteGoodsByProviderId(id);
        //删除供应商
        this.removeById(id);
    }
}
