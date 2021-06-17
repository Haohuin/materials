package com.ethan.bus.vo;

import com.ethan.bus.entity.Goods;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author ethan
 */
@Data
@EqualsAndHashCode
public class GoodsVo extends Goods {
    private Integer page=1;
    private Integer limit=10;
}
