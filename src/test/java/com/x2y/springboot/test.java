package com.x2y.springboot;

import com.x2y.springboot.mapper.CategoryMapper;
import com.x2y.springboot.pojo.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class test {
    @Autowired
    CategoryMapper categoryMapper;

    @Test
    @Rollback(false)
    public void testCategory(){
        List<Category>cs = categoryMapper.findAll();
        for (Category c:cs){
            System.out.println("c.getName():"+c.getName());
        }
    }
}
