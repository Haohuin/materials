package com.ethan.sys.service;

import com.ethan.sys.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ethan
 * @since 2021-03-05
 */
public interface RoleService extends IService<Role> {

    /**
     * 根据用户id查询角色id
     * @param userId
     * @return
     */
    List<Integer> queryUserRoleIdsByUid(Integer userId);


    /**
     * 根据角色id查询权限id和菜单id
     * @param rid
     * @return
     */
    List<Integer> queryRolePermissionIdsByRid(Integer rid);

    /**
     * 保存角色和菜单权限之间的关系
     * @param rid
     * @param ids
     */
    void saveRolePermission(Integer rid, Integer[] ids);
}
