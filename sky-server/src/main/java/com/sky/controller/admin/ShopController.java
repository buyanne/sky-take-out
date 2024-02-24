package com.sky.controller.admin;

import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Api(tags = "店铺接口")
@RequestMapping("/admin/shop")
@RestController("adminShopController")
public class ShopController {

    @Autowired
    private RedisTemplate redisTemplate;

    @ApiOperation("设置店铺营业状态")
    @PutMapping("/{status}")
    public Result status(@PathVariable Integer status) {
        log.info("设置店铺营业状态：{}", status);
        redisTemplate.opsForValue().set("SHOP_STATUS", status);
        return Result.success();
    }

    @ApiOperation("管理端获得点剖状态")
    @GetMapping("/status")
    public Result<Integer> getStatus() {
        log.info("管理端获得店铺状态");
        Integer status = (Integer) redisTemplate.opsForValue().get("SHOP_STATUS");
        return Result.success(status);

    }
}
