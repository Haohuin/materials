package com.ethan.bus.service;

import com.ethan.bus.entity.Outport;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ethan
 * @since 2021-03-07
 */
public interface OutportService extends IService<Outport> {

    /**
     * 对物资入库进行出库处理
     * @param id    入库单ID
     * @param number    出库数量
     * @param remark    备注
     */
    void addOutport(Integer id, Integer number, String remark);

}
