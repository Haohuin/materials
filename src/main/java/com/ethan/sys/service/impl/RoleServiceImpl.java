package com.ethan.sys.service.impl;

import com.ethan.sys.entity.Role;
import com.ethan.sys.mapper.RoleMapper;
import com.ethan.sys.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ethan
 * @since 2021-03-05
 */
@Service
@Transactional
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    /**
     * 根据用户id查询角色id
     * @param id
     * @return
     */
    @Override
    public List<Integer> queryUserRoleIdsByUid(Integer id) {
        return this.getBaseMapper().queryUserRoleIdsByUid(id);
    }

    /**
     * 根据角色id查询权限id和菜单id
     * @param rid
     * @return
     */
    @Override
    public List<Integer> queryRolePermissionIdsByRid(Integer rid) {
        return this.getBaseMapper().queryRolePermissionIdsByRid(rid);
    }

    /**
     * 保存角色和菜单权限之间的关系
     * @param rid
     * @param ids
     */
    @Override
    public void saveRolePermission(Integer rid, Integer[] ids) {
        RoleMapper roleMapper = this.getBaseMapper();
        roleMapper.deleteRolePermissionByRid(rid);
        if (ids!=null&&ids.length>0){
            for (Integer pid : ids){
                roleMapper.saveRolePermission(rid,pid);
            }
        }
    }

    /**
     * 删除角色时同时删除sys_user_role表和sys_role_permission表中的数据
     * @param id    角色id
     * @return
     */
    @Override
    public boolean removeById(Serializable id) {
        //根据角色ID删除sys_role_permission表中的数据
        this.getBaseMapper().deleteRolePermissionByRid(id);
        //根据角色ID删除sys_user_role表中的数据
        this.getBaseMapper().deleteUserRoleByRid(id);
        return super.removeById(id);
    }
}
