package com.ethan.bus.vo;

import com.ethan.bus.entity.Provider;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author ethan
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ProviderVo extends Provider {
    private Integer page=1;
    private Integer limit=10;

    /**
     * 批量删除供应商，存放供应商id的数组
     */
    private Integer[] ids;
}
