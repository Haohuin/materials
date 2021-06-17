package com.ethan.bus.service;

import com.ethan.bus.entity.Goods;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ethan
 * @since 2021-03-07
 */
public interface GoodsService extends IService<Goods> {

    /**
     * 删除物资
     * @param id
     */
    void deleteGoodsById(Integer id);

    /**
     * 加载所有库存物资
     * @return
     */
    List<Goods> loadAllWarning();

}
