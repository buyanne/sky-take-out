package com.sky.controller.admin;

import com.sky.dto.DishDTO;
import com.sky.result.Result;
import com.sky.service.DishService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/admin/dish")
@Api("菜品管理")
public class DishController {

    @Autowired
    private DishService dishService;

    @PostMapping
    @ApiOperation("菜品添加")
    public Result save(@RequestBody DishDTO dishDTO){
        log.info("菜品添加：{}",dishDTO);
        dishService.saveWithFlavor(dishDTO);


        return Result.success();
    }

}
