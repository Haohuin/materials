package com.ethan.bus.mapper;

import com.ethan.bus.entity.Provider;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ethan
 * @since 2021-03-07
 */
public interface ProviderMapper extends BaseMapper<Provider> {

    /**
     * 根据供应商id删除物资出库信息
     * @param id
     */
    void deleteOutPortByProviderId(Integer id);

    /**
     * 根据供应商id删除物资入库信息
     * @param id
     */
    void deleteInportByProviderId(Integer id);

    /**
     * 根据id删除供应商
     * @param id
     */
    void deleteGoodsByProviderId(Integer id);
}
