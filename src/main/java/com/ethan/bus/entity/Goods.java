package com.ethan.bus.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author ethan
 * @since 2021-03-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("bus_goods")
public class Goods implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 物品id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 物品名称
     */
    private String goodsname;

    /**
     * 物品供货单位id
     */
    private Integer providerid;

    /**
     * 物品名称
     */
    private Double price;

    /**
     * 物品数量
     */
    private Integer number;

    /**
     * 物品单位
     */
    private String unit;

    /**
     * 物品预警值
     */
    private Integer dangernum;

    /**
     * 物品描述
     */
    private String description;

    /**
     * 物品图片
     */
    private String goodsimg;

    /**
     * 是否可用，0不可用，1可用
     */
    private Integer available;

    @TableField(exist = false)
    private String providername;

}
