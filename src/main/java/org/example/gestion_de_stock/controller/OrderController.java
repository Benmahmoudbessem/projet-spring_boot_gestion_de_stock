package org.example.gestion_de_stock.controller;

import org.example.gestion_de_stock.entity.Client;
import org.example.gestion_de_stock.entity.Order;
import org.example.gestion_de_stock.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping("/addOrder")
    public String addOrder(Model model){
        Order order = new Order();
        model.addAttribute("Order1",order);
        return "new_order";

    }
    @RequestMapping(value = "/save_order", method = RequestMethod.POST)
    public String saveOrder(@ModelAttribute("Order1") Order order ){
        orderService.createOrder(order);
        return "redirect:/all/order/";
    }
    @RequestMapping("/all/order/")
    public String list(Model model){
        List<Order> listOrder=orderService.getAllOrder();
        model.addAttribute("ListOrder",listOrder);
        return "liste_order";
    }
    @GetMapping("/order/delete/{id}")
    public String deleteOrder(@PathVariable("id")int id, RedirectAttributes redirectAttributes){
        orderService.deleteOrder(id);
        return "redirect:/all/order/";
    }
    @GetMapping("/order/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id,Model model){
        Order order= orderService.getOrderByID(id);
        model.addAttribute("order",order);
        return "update_order";
    }
    @PostMapping("/order/update/{id}")
    public String updateOrder(@PathVariable("id") int id,Order order){
        orderService.UpdateOrder(order);
        return "redirect:/all/order/";
    }

}
