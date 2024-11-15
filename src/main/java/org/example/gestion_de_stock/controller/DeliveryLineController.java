package org.example.gestion_de_stock.controller;

import org.example.gestion_de_stock.entity.DeliveryLine;


import org.example.gestion_de_stock.service.DeliveryLineService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class DeliveryLineController {
    @Autowired
    DeliveryLineService deliveryLineService;



    @RequestMapping("/addDeliveryLine")
    public String addDeliveryLine(Model model){
        DeliveryLine deliveryLine = new DeliveryLine();
        model.addAttribute("DeliveryLine1",deliveryLine);
        return "new_deliveryLine";

    }
    @RequestMapping(value = "/save_deliveryLine", method = RequestMethod.POST)
    public String saveDeliveryLine(@ModelAttribute("DeliveryLine1") DeliveryLine deliveryLine ){
        deliveryLineService.createDeliveryLine(deliveryLine);
        return "redirect:/all/deliveryLine/";
    }
    @RequestMapping("/all/deliveryLine/")
    public String list(Model model){
        List<DeliveryLine> listDeliveryLine=deliveryLineService.getAllDeliveryLine();
        model.addAttribute("ListDeliveryLine",listDeliveryLine);
        return "liste_deliveryLine";
    }
    @GetMapping("/deliveryLine/delete/{id}")
    public String deleteDeliveryLine(@PathVariable("id")int id, RedirectAttributes redirectAttributes){
        deliveryLineService.deleteDeliveryLine(id);
        return "redirect:/all/deliveryLine/";
    }
    @GetMapping("/deliveryLine/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id,Model model){
        DeliveryLine deliveryLine= deliveryLineService.getDeliveryLineByID(id);
        model.addAttribute("DeliveryLine",deliveryLine);
        return "update_deliveryLine";
    }
    @PostMapping("/deliveryLine/update/{id}")
    public String updateDeliveryLine(@PathVariable("id") int id,DeliveryLine deliveryLine){
        deliveryLineService.UpdateDeliveryLine(deliveryLine);
        return "redirect:/all/deliveryLine/";
    }



}
