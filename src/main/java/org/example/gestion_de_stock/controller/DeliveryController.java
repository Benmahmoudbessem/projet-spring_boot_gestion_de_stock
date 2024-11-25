package org.example.gestion_de_stock.controller;

import org.example.gestion_de_stock.entity.Delivery;
import org.example.gestion_de_stock.entity.Delivery;
import org.example.gestion_de_stock.entity.DeliveryLine;
import org.example.gestion_de_stock.entity.Order;
import org.example.gestion_de_stock.service.DeliveryLineService;
import org.example.gestion_de_stock.service.DeliveryService;
import org.example.gestion_de_stock.service.DeliveryService;
import org.example.gestion_de_stock.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;





@Controller
public class DeliveryController {
    @Autowired
    DeliveryService deliveryService;
    @ Autowired
    OrderService orderService;


    @RequestMapping("/addDelivery")
    public String addDelivery(Model model){
        Delivery delivery = new Delivery();
        List<Order> orderList =orderService.getAllOrder();


        model.addAttribute("Delivery1",delivery);
        model.addAttribute("order",orderList);

        return "new_delivery";

    }
    @RequestMapping(value = "/save_delivery", method = RequestMethod.POST)
    public String saveDelivery(@ModelAttribute("Delivery1") Delivery delivery ){
        deliveryService.createDelivery(delivery);
        return "redirect:/all/delivery/";
    }
    @RequestMapping("/all/delivery/")
    public String list(Model model){
        List<Delivery> listDelivery=deliveryService.getAllDelivery();
        model.addAttribute("ListDelivery",listDelivery);
        return "liste_delivery";
    }
    @GetMapping("/delivery/delete/{id}")
    public String deleteDelivery(@PathVariable("id")int id, RedirectAttributes redirectAttributes){
        deliveryService.deleteDelivery(id);
        return "redirect:/all/delivery/";
    }
    @GetMapping("/delivery/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id,Model model){
        Delivery delivery= deliveryService.getDeliveryByID(id);
        model.addAttribute("Delivery",delivery);
        return "update_delivery";
    }
    @PostMapping("/delivery/update/{id}")
    public String updateDelivery(@PathVariable("id") int id,Delivery delivery){
        deliveryService.UpdateDelivery(delivery);
        return "redirect:/all/delivery/";
    }


}
