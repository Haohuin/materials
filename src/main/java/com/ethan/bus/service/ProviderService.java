package com.ethan.bus.service;

import com.ethan.bus.entity.Provider;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ethan
 * @since 2021-03-07
 */
public interface ProviderService extends IService<Provider> {

    /**
     * 根据供应商id删除供应商
     * @param id
     */
    void deleteProviderById(Integer id);
}
