package com.lc.security.demo.mapper;

import com.lc.security.demo.model.User;
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
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return 用户信息
     */
    User selectByUsername(String username);

    /**
     * 更新
     *
     * @param record user
     * @return int
     */
    int updateByPrimaryKeySelective(User record);
}