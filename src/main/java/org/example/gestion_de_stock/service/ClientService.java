package org.example.gestion_de_stock.service;

import org.example.gestion_de_stock.entity.Client;
import org.example.gestion_de_stock.repository.ClientRepository;
import org.example.gestion_de_stock.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public Client createClient(Client client) {return clientRepository.save(client);}
    public List<Client> getAllClient() { return clientRepository.findAll();}
    public Client getClientByID(int id){return clientRepository.findById(id).orElse(null);}
    public Client UpdateClient(Client Client){return clientRepository.saveAndFlush(Client);}
    public void deleteClient(int id){ clientRepository.deleteById(id);}
}
