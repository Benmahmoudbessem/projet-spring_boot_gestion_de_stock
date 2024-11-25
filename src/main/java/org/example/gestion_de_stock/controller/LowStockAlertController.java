package org.example.gestion_de_stock.controller;

import org.example.gestion_de_stock.entity.Invoice;
import org.example.gestion_de_stock.entity.LowStockAlert;
import org.example.gestion_de_stock.entity.Product;
import org.example.gestion_de_stock.service.LowStockAlertService;
import org.example.gestion_de_stock.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class LowStockAlertController {
    @Autowired
    LowStockAlertService lowStockAlertService;
@Autowired
    ProductService productService;

    @RequestMapping("/addLowStockAlert")
    public String addLowStockAlert(Model model){
        LowStockAlert lowStockAlert =new LowStockAlert();
        List<Product> productList= productService.getAllProduct();
        model.addAttribute("lowStockAlert1", lowStockAlert);
        model.addAttribute("product",productList);
        return "new_lowStockAlert";
    }
    @RequestMapping(value = "/save_lowStockAlert", method = RequestMethod.POST)
    public String saveLowStockAlert(@ModelAttribute("lowStockAlert1") LowStockAlert lowStockAlert){
        lowStockAlertService.createLowStockAlert(lowStockAlert);
        return "redirect:/all/lowStockAlert/";
    }


    @RequestMapping("/all/lowStockAlert/")
    public String list(Model model){
        List<LowStockAlert> listLowStockAlert=lowStockAlertService.getAllLowStockAlert();
        model.addAttribute("ListLowStockAlert",listLowStockAlert);
        return "liste_lowStockAlert";
    }

    @GetMapping("/lowStockAlert/delete/{id}")
    public String deleteLowStockAlert(@PathVariable("id")int id, RedirectAttributes redirectAttributes){
        lowStockAlertService.deleteLowStockAlert(id);
        return "redirect:/all/lowStockAlert/";
    }
    @GetMapping("/lowStockAlert/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id,Model model){
        LowStockAlert lowStockAlert= lowStockAlertService.getLowStockAlertByID(id);
        model.addAttribute("lowStockAlert",lowStockAlert);
        return "update_lowStockAlert";
    }
    @PostMapping("/lowStockAlert/update/{id}")
    public String updateLowStockAlert(@PathVariable("id") int id,LowStockAlert lowStockAlert ){
        lowStockAlertService.UpdateLowStockAlert(lowStockAlert);
        return "redirect:/all/lowStockAlert/";
    }


}
