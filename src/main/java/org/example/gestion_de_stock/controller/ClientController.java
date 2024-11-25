package org.example.gestion_de_stock.controller;

import org.example.gestion_de_stock.entity.Client;
import org.example.gestion_de_stock.entity.Order;
import org.example.gestion_de_stock.entity.Product;
import org.example.gestion_de_stock.service.ClientService;
import org.example.gestion_de_stock.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ClientController {
    @Autowired
    ClientService clientService;


    @RequestMapping("/addClient")
    public String addClient(Model model){
        Client client = new Client();

        model.addAttribute("Client1",client);


        return "new_client";

    }
    @RequestMapping(value = "/save_client", method = RequestMethod.POST)
    public String saveClient(@ModelAttribute("Client1") Client client ){
        clientService.createClient(client);
        return "redirect:/all/client/";
    }
    @RequestMapping("/all/client/")
    public String list(Model model){
        List<Client> listClient=clientService.getAllClient();
        model.addAttribute("ListClient",listClient);
        return "liste_client";
    }
    @GetMapping("/client/delete/{id}")
    public String deleteClient(@PathVariable("id")int id, RedirectAttributes redirectAttributes){
        clientService.deleteClient(id);
        return "redirect:/all/client/";
    }
    @GetMapping("/client/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id,Model model){
        Client client= clientService.getClientByID(id);
        model.addAttribute("client",client);
        return "update_client";
    }
    @PostMapping("/client/update/{id}")
    public String updateClient(@PathVariable("id") int id,Client client){
        clientService.UpdateClient(client);
        return "redirect:/all/client/";
    }


}
