package com.x2y.springboot.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.x2y.springboot.mapper.CategoryMapper;
import com.x2y.springboot.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    CategoryMapper categoryMapper;

    @GetMapping("/categories")
    public String listCategory
            (Model m, @RequestParam(value="start",defaultValue = "0")int start,@RequestParam(value = "size",defaultValue = "5")int size)throws  Exception{
        PageHelper.startPage(start,size,"id asc");
        List<Category> cs = categoryMapper.findAll();
        PageInfo<Category>pageInfo = new PageInfo<>(cs);

        m.addAttribute("page",pageInfo);
        return "listCategory";
    }

    @PostMapping("/categories")
    public String listCategory(Category c)throws Exception{
        categoryMapper.save(c);
        return "redirect:/categories";
    }

    @DeleteMapping("/categories/{id}")
    public String deleteCategory(Category c)throws Exception{
        categoryMapper.delete(c);
        return "redirect:/categories";
    }

    @PutMapping("/categories/{id}")
    public String updataCategory(Category c)throws Exception{
        categoryMapper.update(c);
        return "redirect:/categories";
    }

    @GetMapping("/categories/{id}")
    public String getCategory(@PathVariable("id")int id,Model m) throws Exception {
        Category c= categoryMapper.get(id);
        m.addAttribute("c", c);
        return "editCategory";
    }


    //ajax练习
    @PutMapping("/category")
    public void addCategory(@RequestBody Category category) throws Exception {
        System.out.println("springboot接受到浏览器以JSON格式提交的数据："+category);
    }

    @GetMapping("/category/{id}")
    public Category getCategory(@PathVariable("id")int id)throws Exception{
        Category c = categoryMapper.get(id);
        System.out.println(c);
        return c;
    }

    @GetMapping("/category")
    public List<Category>listCategory(@RequestParam(value = "start", defaultValue = "0") int start,
                                      @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = size<0?0:start;
        PageHelper.startPage(start,size,"id asc");
        List<Category> cs = categoryMapper.findAll();
        PageInfo<Category>pageInfo = new PageInfo<>(cs);

        System.out.println(pageInfo);
        return  pageInfo.getList();
    }
}














