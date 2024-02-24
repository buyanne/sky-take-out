package com.sky.controller.user;

import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController("userShopController")
@RequestMapping("/user/shop")
@Api(tags = "用户端店铺查询状态")
public class ShopController {
    @Autowired
    private RedisTemplate redisTemplate;

    @ApiOperation("管理端获得点剖状态")
    @GetMapping("/status")
    public Result<Integer> getStatus() {
        log.info("管理端获得店铺状态");
        Integer status = (Integer) redisTemplate.opsForValue().get("SHOP_STATUS");
        return Result.success(status);
    }
}
