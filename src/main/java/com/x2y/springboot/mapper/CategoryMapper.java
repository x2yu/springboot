package com.x2y.springboot.mapper;

import com.x2y.springboot.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapper {
    //@Select("select * from category_") 注解的方式
    List<Category>findAll();

    public int save(Category category);

    public void delete(Category c);

    public Category get(int id);

    public int update(Category category);
}
