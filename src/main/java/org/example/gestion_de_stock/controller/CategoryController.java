package org.example.gestion_de_stock.controller;

import org.example.gestion_de_stock.entity.Category;
import org.example.gestion_de_stock.entity.Product;
import org.example.gestion_de_stock.service.CategoryService;

import org.example.gestion_de_stock.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class CategoryController{
    @Autowired
    CategoryService categoryService;



    @RequestMapping("/addCategory")
     public String addCategory(Model model){
         Category category=new Category();


       model.addAttribute("category1", category);

         return "new_category";
     }

    @RequestMapping(value = "/save_category", method = RequestMethod.POST)
    public String saveCategory(@ModelAttribute("Category1") Category category){
        categoryService.createCategory(category);
        return "redirect:/all";
    }


    @RequestMapping("/all")
    public String list(Model model){
        List<Category> listCategory=categoryService.getAllCategory();
        model.addAttribute("ListCategory",listCategory);
        return "liste_category";
}

    @GetMapping("delete/{id}")
    public String deleteCategory(@PathVariable("id")int id, RedirectAttributes redirectAttributes){
        categoryService.deleteCategory(id);
        return "redirect:/all";
    }
    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id,Model model){
        Category category= categoryService.getCategoryByID(id);
        model.addAttribute("category",category);
        return "update_category";
    }
    @PostMapping("update/{id}")
    public String updateCategory(@PathVariable("id") int id,Category category ){
        categoryService.UpdateCategory(category);
        return "redirect:/all";
    }


}
