package com.pluralsight.controllers;

import com.pluralsight.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
public class CategoriesController
{
    CategoryRepository categoryRepository;

    @Autowired
    public CategoriesController(CategoryRepository categoryRepository)
    {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/categories")
    public String index(Model model)
    {
        var categories = categoryRepository.findAll();

        model.addAttribute("categories",categories);
        return "categories/index";
    }


}
