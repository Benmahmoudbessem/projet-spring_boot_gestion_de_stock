package org.example.gestion_de_stock.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Page d'accueil");
        return "home"; // Renvoie vers home.html dans le dossier templates
    }
}
