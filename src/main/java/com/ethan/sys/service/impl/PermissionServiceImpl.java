package com.ethan.sys.service.impl;

import com.ethan.sys.entity.Permission;
import com.ethan.sys.mapper.PermissionMapper;
import com.ethan.sys.service.PermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ethan
 * @since 2021-03-05
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {
    @Override
    public boolean removeById(Serializable id) {

        //根据权限ID或菜单ID删除sys_role_permission表中的数据
        PermissionMapper permissionMapper = this.getBaseMapper();
        permissionMapper.deleteRolePermissionByPid(id);
        //删除权限表中的数据
        return super.removeById(id);
    }

}
