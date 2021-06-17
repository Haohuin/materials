package com.ethan.bus.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

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
@TableName("bus_outport")
public class Outport implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 出库编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 出库时间
     */
    private Date outporttime;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 物资数量
     */
    private Integer number;

    /**
     * 物资价格
     */
    private Double price;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 物资供货单位id
     */
    private Integer providerid;

    /**
     * 物品id
     */
    private Integer goodsid;

    /**
     * 供应商名称
     */
    @TableField(exist = false)
    private String providername;

    /**
     * 物资名称
     */
    @TableField(exist = false)
    private String goodsname;

    /**
     * 物资规格
     */
    @TableField(exist = false)
    private String unit;


}
