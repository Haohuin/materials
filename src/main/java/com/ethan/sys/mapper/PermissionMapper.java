package com.ethan.sys.mapper;

import com.ethan.sys.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.io.Serializable;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ethan
 * @since 2021-03-05
 */
public interface PermissionMapper extends BaseMapper<Permission> {

    /**
     * 根据权限id或菜单id删除sys_role_permission表里的数据
     * @param id
     */
    void deleteRolePermissionByPid(Serializable id);
}
