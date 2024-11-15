package org.example.gestion_de_stock.service;

import org.example.gestion_de_stock.entity.Category;
import org.example.gestion_de_stock.entity.Product;
import org.example.gestion_de_stock.repository.CategoryRepository;
import org.example.gestion_de_stock.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public Category createCategory(Category category) {return categoryRepository.save(category);}
    public List<Category> getAllCategory() { return categoryRepository.findAll();}
    public Category getCategoryByID(int id){return categoryRepository.findById(id).orElse(null);}
    public Category UpdateCategory(Category category){return categoryRepository.saveAndFlush(category);}
    public void deleteCategory(int id){ categoryRepository.deleteById(id);}
}
