package com.example.demo.swagger.controller;


import com.example.demo.swagger.entity.SwaggerInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "swagger相关接口")
@RequestMapping("/myswagger")
public class SwaggerController {

    @PostMapping("/")
    @ApiOperation("添加信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", defaultValue = "张三"),
            @ApiImplicitParam(name = "address", value = "地址", defaultValue = "深圳", required = true)
    })
    public SwaggerInfo addInfo(String username, @RequestParam(required = true) String address) {
        return new SwaggerInfo(username, address);
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查询信息接口")
    @ApiImplicitParam(name = "id", value = "信息id", defaultValue = "99", required = true)
    public SwaggerInfo getUserById(@PathVariable Integer id) {
        SwaggerInfo user = new SwaggerInfo();
        user.setId(id);
        return user;
    }


    @PutMapping("/")
    @ApiOperation("更新信息的接口")
    public SwaggerInfo updateUserById(@RequestBody SwaggerInfo info) {
        return info;
    }


}
