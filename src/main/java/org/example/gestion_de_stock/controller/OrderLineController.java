package org.example.gestion_de_stock.controller;

import org.example.gestion_de_stock.entity.Order;
import org.example.gestion_de_stock.entity.OrderLine;
import org.example.gestion_de_stock.entity.Product;
import org.example.gestion_de_stock.service.OrderLineService;
import org.example.gestion_de_stock.service.OrderService;
import org.example.gestion_de_stock.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class OrderLineController {
    @Autowired
    OrderLineService orderLineService;
    @Autowired
    OrderService orderService;
    @Autowired
    ProductService productService;

    @RequestMapping("/addOrderLine")
    public String addOrderLine(Model model){
        OrderLine orderLine = new OrderLine();
        List<Order> orderList= orderService.getAllOrder();
        List<Product> productList= productService.getAllProduct();

        model.addAttribute("OrderLine1",orderLine);
        model.addAttribute("order",orderList);
        model.addAttribute("product",productList);
        return "new_orderLine";

    }
    @RequestMapping(value = "/save_orderLine", method = RequestMethod.POST)
    public String saveOrderLine(@ModelAttribute("OrderLine1") OrderLine orderLine ){
        orderLineService.createOrderLine(orderLine);
        return "redirect:/all/orderLine/";
    }
    @RequestMapping("/all/orderLine/")
    public String list(Model model){
        List<OrderLine> listOrderLine=orderLineService.getAllOrderLine();
        model.addAttribute("ListOrderLine",listOrderLine);
        return "liste_orderLine";
    }
    @GetMapping("/orderLine/delete/{id}")
    public String deleteOrderLine(@PathVariable("id")int id, RedirectAttributes redirectAttributes){
        orderLineService.deleteOrderLine(id);
        return "redirect:/all/orderLine/";
    }
    @GetMapping("/orderLine/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id,Model model){
        OrderLine orderLine= orderLineService.getOrderLineByID(id);
        model.addAttribute("orderLine",orderLine);
        return "update_orderLine";
    }
    @PostMapping("/orderLine/update/{id}")
    public String updateOrderLine(@PathVariable("id") int id,OrderLine orderLine){
        orderLineService.UpdateOrderLine(orderLine);
        return "redirect:/all/orderLine/";
    }


}
