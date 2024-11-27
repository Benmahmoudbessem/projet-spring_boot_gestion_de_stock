package org.example.gestion_de_stock.controller;

import org.example.gestion_de_stock.entity.Category;
import org.example.gestion_de_stock.entity.Client;
import org.example.gestion_de_stock.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("client")
public class ClientRestController {

    @Autowired
    ClientService clientService;

    @PostMapping("/save")
    public Client saveClient(@RequestBody Client client){
        return clientService.createClient(client);
    }

    @GetMapping("/all")
    public List<Client> getAllClient(){
        return clientService.getAllClient();
    }
    @GetMapping("/getone/{id}")
    public Client getoneClient(@PathVariable int id){
        return clientService.getClientByID(id);
    }
    @PutMapping("/update/{id}")
    public Client updateClient(@PathVariable int id , @RequestBody Client client) {
        Client cl1 = clientService.getClientByID(id);
        if (cl1 != null) {
            client.setId((long) id);
            return clientService.UpdateClient(client);
        } else {
            throw new RuntimeException("failed!");
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteClient(@PathVariable("id") int id){
        try {
            clientService.deleteClient(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e){
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

}
