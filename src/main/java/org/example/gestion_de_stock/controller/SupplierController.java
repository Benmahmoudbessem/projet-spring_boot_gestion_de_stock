package org.example.gestion_de_stock.controller;

import org.example.gestion_de_stock.entity.Product;
import org.example.gestion_de_stock.entity.Supplier;
import org.example.gestion_de_stock.service.ProductService;
import org.example.gestion_de_stock.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class SupplierController {
    @Autowired
    SupplierService supplierService;


    @RequestMapping("/addSupplier")
    public String addSupplier(Model model){
        Supplier supplier = new Supplier();


        model.addAttribute("Supplier1",supplier);

        return "new_supplier";

    }
    @RequestMapping(value = "/save_supplier", method = RequestMethod.POST)
    public String saveSupplier(@ModelAttribute("Supplier1") Supplier supplier ){
        supplierService.createSupplier(supplier);
        return "redirect:/all/supplier/";
    }
    @RequestMapping("/all/supplier/")
    public String list(Model model){
        List<Supplier> listSupplier=supplierService.getAllSupplier();
        model.addAttribute("ListSupplier",listSupplier);
        return "liste_supplier";
    }
    @GetMapping("/supplier/delete/{id}")
    public String deleteSupplier(@PathVariable("id")int id, RedirectAttributes redirectAttributes){
        supplierService.deleteSupplier(id);
        return "redirect:/all/supplier/";
    }
    @GetMapping("/supplier/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id,Model model){
        Supplier supplier = supplierService.getSupplierByID(id);
        model.addAttribute("supplier",supplier);
        return "update_supplier";
    }
    @PostMapping("/supplier/update/{id}")
    public String updateSupplier(@PathVariable("id") int id,Supplier supplier){
        supplierService.UpdateSupplier(supplier);
        return "redirect:/all/supplier/";
    }

}
