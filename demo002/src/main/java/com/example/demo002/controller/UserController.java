package com.example.demo002.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(tags = {" demo002 用户接口 "})
@RestController
public class UserController {

    @ApiOperation(value = "查询用户")
    @GetMapping("/user")
    public String getUser(@RequestParam("id") String id) {
        return id;
    }

}
