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
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    ClientService clientService;

    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    DeliveryService deliveryService;


    @RequestMapping("/addOrder")
    public String addOrder(Model model){
        Order order = new Order();
        List<Client> clientList=clientService.getAllClient();

        List<Invoice> invoiceList= invoiceService.getAllInvoice();
        List<Delivery> deliveryList=deliveryService.getAllDelivery();

        model.addAttribute("Order1",order);
        model.addAttribute("client",clientList);

        model.addAttribute("invoice",invoiceList);
        model.addAttribute("delivery",deliveryList);
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
