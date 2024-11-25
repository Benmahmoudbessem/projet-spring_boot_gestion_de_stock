package org.example.gestion_de_stock.controller;


import org.example.gestion_de_stock.entity.Invoice;

import org.example.gestion_de_stock.entity.Order;
import org.example.gestion_de_stock.service.InvoiceService;
import org.example.gestion_de_stock.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class InvoiceController {
    @Autowired
    InvoiceService invoiceService;
    @Autowired
    OrderService orderService;


        @RequestMapping("/addInvoice")
        public String addInvoice(Model model){
            Invoice invoice =new Invoice();
            List<Order> orderList= orderService.getAllOrder();
            model.addAttribute("invoice1", invoice);
            model.addAttribute("order",orderList);
            return "new_invoice";
        }
        @RequestMapping(value = "/save_invoice", method = RequestMethod.POST)
        public String saveInvoice(@ModelAttribute("Invoice1") Invoice invoice){
            invoiceService.createInvoice(invoice);
            return "redirect:/all/invoice/";
        }


        @RequestMapping("/all/invoice/")
        public String list(Model model){
            List<Invoice> listInvoice=invoiceService.getAllInvoice();
            model.addAttribute("ListInvoice",listInvoice);
            return "liste_invoice";
        }

        @GetMapping("/invoice/delete/{id}")
        public String deleteInvoice(@PathVariable("id")int id, RedirectAttributes redirectAttributes){
            invoiceService.deleteInvoice(id);
            return "redirect:/all/invoice/";
        }
        @GetMapping("/invoice/edit/{id}")
        public String showUpdateForm(@PathVariable("id") int id,Model model){
            Invoice invoice= invoiceService.getInvoiceByID(id);
            model.addAttribute("invoice",invoice);
            return "update_invoice";
        }
        @PostMapping("/invoice/update/{id}")
        public String updateInvoice(@PathVariable("id") int id,Invoice invoice ){
            invoiceService.UpdateInvoice(invoice);
            return "redirect:/all/invoice/";
        }


    }





