package com.ethan.bus.entity;

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
@TableName("bus_provider")
public class Provider implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 供货单位名称
     */
    private String providername;

    /**
     * 供货单位电话
     */
    private String telephone;

    /**
     * 供货单位地址
     */
    private String address;

    /**
     * 供货单位联系人
     */
    private String contact;

    /**
     * 供货单位邮箱
     */
    private String email;

    /**
     * 供货单位传真
     */
    private String fax;

    /**
     * 供货单位银行账号
     */
    private String bankaccount;

    /**
     * 是否可用，0不可用，1可用
     */
    private Integer available;


}
