package com.ethan.bus.mapper;

import com.ethan.bus.entity.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ethan
 * @since 2021-03-07
 */
public interface GoodsMapper extends BaseMapper<Goods> {

    /**
     * 删除物资入库信息
     * @param id
     */
    void deleteInportByGoodsId(Integer id);

    /**
     * 删除物资出库信息
     * @param id
     */
    void deleteOutportByGoodsId(Integer id);

    /**
     * 加载预警物资
     * @return
     */
    List<Goods> loadAllWarning();

}
