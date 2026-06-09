package com.pluralsight.controllers;

import com.pluralsight.models.Product;
import com.pluralsight.services.CategoryDao;
import com.pluralsight.services.mysql.MySqlCategoryDao;
import com.pluralsight.services.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductsController
{
    private CategoryDao categoryDao;
    private ProductDao productDao;

    @Autowired
    public ProductsController(CategoryDao categoryDao, ProductDao productDao)
    {
        this.categoryDao = categoryDao;
        this.productDao = productDao;
    }

    // list all categories
    @GetMapping( "/products")
    public String products(Model model, @RequestParam(name = "cid", defaultValue = "1") int categoryId)
    {
        model.addAttribute("products", productDao.getProductsByCategory(categoryId));
        model.addAttribute("category", categoryDao.getCategory(categoryId));
        return "products/index";
    }

    // details page
    @GetMapping("/products/{id}")
    public String getProduct(Model model, @PathVariable int id)
    {
        var product = productDao.getProduct(id);

        if(product == null)
        {
            return "404";
        }

        var category = categoryDao.getCategory(product.getCategoryId());

        model.addAttribute("category", category);
        model.addAttribute("product", product);
        return "products/details";
    }

    // add category
    @GetMapping("/products/new")
    public String addCategory(Model model, @RequestParam(name = "cid", defaultValue = "1") int categoryId)
    {
        model.addAttribute("categories", categoryDao.getCategories());
        model.addAttribute("product", new Product(){{setCategoryId(categoryId);}});
        return "products/add";
    }

    @PostMapping("/products/new")
    public String saveCategory(@ModelAttribute("product") Product product)
    {
        productDao.addProduct(product);
        return "redirect:/products";
    }

    // edit category
    @GetMapping("/products/{id}/edit")
    public String editCategory(Model model, @PathVariable int id)
    {
        var product = productDao.getProduct(id);

        if(product == null)
        {
            return "404";
        }

        model.addAttribute("categories", categoryDao.getCategories());
        model.addAttribute("product", product);
        return "products/edit";
    }

    @PostMapping("/products/{id}/edit")
    public String editCategory(@ModelAttribute("product") Product product, @PathVariable int id)
    {
        var currentProduct = productDao.getProduct(id);

        if(currentProduct == null)
        {
            return "404";
        }

        product.setProductId(id);
        productDao.updateProduct(product);

        return "redirect:/products";
    }


    // edit category
    @GetMapping("/products/{id}/delete")
    public String deleteCategory(Model model, @PathVariable int id)
    {
        var product = productDao.getProduct(id);

        if(product == null)
        {
            return "404";
        }

        var category = categoryDao.getCategory(product.getCategoryId());

        model.addAttribute("category", category);
        model.addAttribute("product", product);
        return "products/delete";
    }

    @PostMapping("/products/{id}/delete")
    public String deleteCategoryConfirm(@PathVariable int id)
    {
        var currentProduct = productDao.getProduct(id);

        if(currentProduct == null)
        {
            return "404";
        }

        productDao.deleteProduct(id);

        return "redirect:/products";
    }
}
