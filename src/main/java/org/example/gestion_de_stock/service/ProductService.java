package org.example.gestion_de_stock.service;

import org.example.gestion_de_stock.entity.Product;
import org.example.gestion_de_stock.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Product createProduct(Product product) {return productRepository.save(product);}
    public List<Product> getAllProduct() { return productRepository.findAll();}
    public Product getProductByID(int id){return productRepository.findById(id).orElse(null);}
    public Product UpdateProduct(Product product){return productRepository.saveAndFlush(product);}
    public void deleteProduct(int id){ productRepository.deleteById(id);}
}
