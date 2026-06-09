package com.pluralsight.controllers;

import com.pluralsight.models.Category;
import com.pluralsight.services.CategoryDao;
import com.pluralsight.services.mysql.MySqlCategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoriesController
{
    private CategoryDao categoryDao;

    @Autowired
    public CategoriesController(CategoryDao categoryDao)
    {
        this.categoryDao = categoryDao;
    }

    // list all categories
    @GetMapping( "/categories")
    public String categories(Model model)
    {
        model.addAttribute("categories", categoryDao.getCategories());
        return "categories/index";
    }

    // details page
    @GetMapping("/categories/{id}")
    public String getCategory(Model model, @PathVariable int id)
    {
        var category = categoryDao.getCategory(id);

        if(category == null)
        {
            return "404";
        }

        model.addAttribute("category", category);
        return "categories/details";
    }

    // add category
    @GetMapping("/categories/new")
    public String addCategory(Model model)
    {
        model.addAttribute("category", new Category());
        return "categories/add";
    }

    @PostMapping("/categories/new")
    public String saveCategory(@ModelAttribute("category") Category category)
    {
        categoryDao.addCategory(category);
        return "redirect:/categories";
    }

    // edit category
    @GetMapping("/categories/{id}/edit")
    public String editCategory(Model model, @PathVariable int id)
    {
        var category = categoryDao.getCategory(id);

        if(category == null)
        {
            return "404";
        }

        model.addAttribute("category", category);
        return "categories/edit";
    }

    @PostMapping("/categories/{id}/edit")
    public String editCategory(@ModelAttribute("category") Category category, @PathVariable int id)
    {
        var currentCategory = categoryDao.getCategory(id);

        if(currentCategory == null)
        {
            return "404";
        }

        categoryDao.updateCategory(category);

        return "redirect:/categories";
    }


    // edit category
    @GetMapping("/categories/{id}/delete")
    public String deleteCategory(Model model, @PathVariable int id)
    {
        var category = categoryDao.getCategory(id);

        if(category == null)
        {
            return "404";
        }

        model.addAttribute("category", category);
        return "categories/delete";
    }

    @PostMapping("/categories/{id}/delete")
    public String deleteCategoryConfirm(@PathVariable int id)
    {
        var currentCategory = categoryDao.getCategory(id);

        if(currentCategory == null)
        {
            return "404";
        }

        categoryDao.deleteCategory(id);

        return "redirect:/categories";
    }
}
