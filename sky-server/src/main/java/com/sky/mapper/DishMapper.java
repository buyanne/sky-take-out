package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.enumeration.OperationType;
import com.sky.vo.DishVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DishMapper {

    /**
     * 根据分类id查询菜品数量
     *
     * @param categoryId
     * @return
     */
    @Select("select count(id) from dish where category_id = #{categoryId}")
    Integer countByCategoryId(Long categoryId);


    @AutoFill(OperationType.INSERT)
    void insert(Dish dish);


    @Select("select * from dish where id=#{id}")
    Dish getDishById(Long id);

    @Delete("delete from dish where id=#{id}")
    void deleteDishById(Long id);

    void deleteDishByIds(List<Long> ids);

    Page<DishVO> pageQuery(DishPageQueryDTO dishPageQueryDTO);

    @AutoFill(OperationType.UPDATE)
    void update(Dish dish);

    @Select("select * from dish where category_id=#{categoryId}")
    List<Dish> list(Long categoryId);

    @Select("select d.* from dish d left join setmeal_dish sd on d.id=sd.dish_id where sd.setmeal_id=#{setmealId}")
    List<Dish> getDishesBySetMealId(Long id);
}
