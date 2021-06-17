package com.ethan.sys.service;

import com.ethan.sys.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ethan
 * @since 2021-03-05
 */
public interface UserService extends IService<User> {

    void saveUserRole(Integer uid, Integer[] ids);
}
