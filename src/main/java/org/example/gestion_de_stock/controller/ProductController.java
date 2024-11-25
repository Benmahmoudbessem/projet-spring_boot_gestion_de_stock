package org.example.gestion_de_stock.controller;

import org.example.gestion_de_stock.entity.*;
import org.example.gestion_de_stock.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    SupplierService supplierService;



    @RequestMapping("/addProduct")
    public String addProduct(Model model){
        Product product = new Product();
        List<Category> categoryList=categoryService.getAllCategory();
        List<Supplier> supplierList=supplierService.getAllSupplier();


        model.addAttribute("Product1",product);
        model.addAttribute("category", categoryList);
        model.addAttribute("supplier", supplierList);

        return "new_product";

    }
    @RequestMapping(value = "/save_product", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("Product1") Product product ){
        productService.createProduct(product);
        return "redirect:/all/product/";
    }
    @RequestMapping("/all/product/")
    public String list(Model model){
        List<Product> listProduct=productService.getAllProduct();
        model.addAttribute("ListProduct",listProduct);
        return "liste_product";
    }
    @GetMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable("id")int id, RedirectAttributes redirectAttributes){
        productService.deleteProduct(id);
        return "redirect:/all/product/";
    }
    @GetMapping("/product/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id,Model model){
        Product product= productService.getProductByID(id);
        model.addAttribute("product",product);
        return "update_product";
    }
    @PostMapping("/product/update/{id}")
    public String updateProduct(@PathVariable("id") int id,Product product){
        productService.UpdateProduct(product);
        return "redirect:/all/product/";
    }



}
