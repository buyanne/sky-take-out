package com.sky.service;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.vo.SetmealVO;

import java.util.List;

public interface SetMealService {
    PageResult pageQuery(SetmealPageQueryDTO setmealPageQueryDTO);

    void save(SetmealDTO setmealDTO);

    void deleteBatch(List<Long> ids);

    SetmealVO getSetMealByIdWithDish(Long id);

    void update(SetmealDTO setmealDTO);

    void updateStartOrStop(Integer status, Long id);
}
