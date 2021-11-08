package com.lc.security.demo.service;

import com.lc.security.demo.pojo.dto.UserDTO;
import com.lc.security.demo.pojo.vo.UserVO;

/**
 * UserService
 *
 * @author luchao
 * @date 2021/11/8
 */
public interface UserService {

    /**
     * 新增
     *
     * @param dto dto
     */
    void add(UserDTO dto);

    /**
     * 修改
     *
     * @param dto dto
     */
    void update(UserDTO dto);

    /**
     * 删除
     *
     * @param id 主键ID
     */
    void delete(Integer id);

    /**
     * 详情
     *
     * @param id 主键ID
     * @return 详情
     */
    UserVO detail(Integer id);
}
