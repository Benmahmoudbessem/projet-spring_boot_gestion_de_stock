package org.example.gestion_de_stock.controller;

import org.example.gestion_de_stock.entity.Category;
import org.example.gestion_de_stock.entity.Product;
import org.example.gestion_de_stock.entity.StockMovement;
import org.example.gestion_de_stock.service.ProductService;
import org.example.gestion_de_stock.service.StockMovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class StockMovementController {

    @Autowired
    StockMovementService stockMovementService;
    @Autowired
    ProductService productService;

    @RequestMapping("/addStockMovement")
    public String addStockMovement(Model model){
        StockMovement stockMovement = new StockMovement();
        List<Product> productList= productService.getAllProduct();

        model.addAttribute("StockMovement1",stockMovement);
        model.addAttribute("product",productList);
        return "new_stockMovement";

    }
    @RequestMapping(value = "/save_stockMovement", method = RequestMethod.POST)
    public String saveStockMovement(@ModelAttribute("StockMovement1") StockMovement stockMovement ){
        stockMovementService.createStockMovement(stockMovement);
        return "redirect:/all/stockMovement/";
    }
    @RequestMapping("/all/stockMovement/")
    public String list(Model model){
        List<StockMovement> listStockMovement=stockMovementService.getAllStockMovement();
        model.addAttribute("ListStockMovement",listStockMovement);
        return "liste_stockMovement";
    }
    @GetMapping("/stockMovement/delete/{id}")
    public String deleteStockMovement(@PathVariable("id")int id, RedirectAttributes redirectAttributes){
        stockMovementService.deleteStockMovement(id);
        return "redirect:/all/stockMovement/";
    }
    @GetMapping("/stockMovement/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id,Model model){
        StockMovement stockMovement= stockMovementService.getStockMovementByID(id);
        model.addAttribute("stockMovement",stockMovement);
        return "update_stockMovement";
    }
    @PostMapping("/stockMovement/update/{id}")
    public String updateStockMovement(@PathVariable("id") int id,StockMovement stockMovement){
        stockMovementService.UpdateStockMovement(stockMovement);
        return "redirect:/all/stockMovement/";
    }

}

