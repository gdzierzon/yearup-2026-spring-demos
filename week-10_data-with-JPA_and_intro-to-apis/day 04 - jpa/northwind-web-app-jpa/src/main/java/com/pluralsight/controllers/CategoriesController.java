package com.pluralsight.controllers;

import com.pluralsight.models.Category;
import com.pluralsight.repositories.CategoriesRepository;
import com.pluralsight.services.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@Controller
public class CategoriesController
{
    CategoriesService categoriesService;

    @Autowired
    public CategoriesController(CategoriesService categoriesService)
    {
        this.categoriesService = categoriesService;
    }



    @GetMapping("/categories")
    public List<Category> index(Model model)
    {
        var categories = categoriesService.findAllCategories();
        return categories;

//        model.addAttribute("categories",categories);
//        return "categories/index";
    }


}
