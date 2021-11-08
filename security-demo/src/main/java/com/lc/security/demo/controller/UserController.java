package com.lc.security.demo.controller;

import com.lc.security.demo.pojo.dto.UserDTO;
import com.lc.security.demo.pojo.vo.UserVO;
import com.lc.security.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * UserController
 *
 * @author luchao
 * @date 2021/11/8
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/register")
    @ApiModelProperty("注册")
    public void register(@RequestBody UserDTO dto) {
        userService.add(dto);
    }

    @PutMapping("/update")
    @ApiModelProperty("编辑")
    public void update(UserDTO dto) {
        userService.update(dto);
    }

    @Delete("/del/{id}")
    @ApiModelProperty("删除")
    public void delete(@PathVariable Integer id) {
        userService.delete(id);
    }

    @GetMapping("/detail/{id}")
    @ApiModelProperty("详情")
    public UserVO detail(@PathVariable Integer id) {
        return userService.detail(id);
    }
}
