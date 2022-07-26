package com.example.demo001.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {" demo001 用户接口 "})
@RestController
public class UserController {

    @ApiOperation(value = " demo001 查询用户")
    @GetMapping("/user")
    public String getUser(@RequestParam("id") String id) {
        return id;
    }

}
