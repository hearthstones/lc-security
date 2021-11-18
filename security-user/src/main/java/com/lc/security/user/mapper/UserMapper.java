package com.lc.security.user.mapper;

import com.lc.security.user.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户 Mapper
 *
 * @author hearthstones
 * @date 2021/11/8
 */
@Mapper
public interface UserMapper {
    /**
     * 根据主键ID删除
     *
     * @param id 主键ID
     */
    void deleteByPrimaryKey(Integer id);

    /**
     * 插入
     *
     * @param record user
     */
    void insert(User record);

    /**
     * 根据主键查询
     *
     * @param id 主键ID
     * @return user
     */
    User selectByPrimaryKey(Integer id);

    /**
     * 根据手机号查询用户信息
     *
     * @param mobile 手机号
     * @return 用户信息
     */
    User selectByMobile(String mobile);

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return 用户信息
     */
    User selectByUsername(String username);

    /**
     * 根据 用户 获取 UserDetails
     *
     * @param principal 用户名/手机号
     * @return 用户信息
     */
    User selectByPrincipal(String principal);

    /**
     * 更新
     *
     * @param record user
     * @return int
     */
    int updateByPrimaryKeySelective(User record);
}