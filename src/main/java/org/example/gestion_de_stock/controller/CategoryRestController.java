package org.example.gestion_de_stock.controller;

import org.example.gestion_de_stock.entity.Category;
import org.example.gestion_de_stock.entity.Order;
import org.example.gestion_de_stock.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("category")
public class CategoryRestController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/save")
    public Category saveCategory(@RequestBody Category category){
        return categoryService.createCategory(category);
    }

    @GetMapping("/all")
    public List<Category> getAllCategory(){
        return categoryService.getAllCategory();
    }
    @GetMapping("/getone/{id}")
    public Category getoneCategory(@PathVariable int id){
        return categoryService.getCategoryByID(id);
    }
    @PutMapping("/update/{id}")
    public Category updateCategory(@PathVariable int id , @RequestBody Category category) {
        Category cat1 = categoryService.getCategoryByID(id);
        if (cat1 != null) {
            category.setId((long) id);
            return categoryService.UpdateCategory(category);
        } else {
            throw new RuntimeException("failed!");
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteCategory(@PathVariable("id") int id){
        try {
            categoryService.deleteCategory(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e){
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

}
