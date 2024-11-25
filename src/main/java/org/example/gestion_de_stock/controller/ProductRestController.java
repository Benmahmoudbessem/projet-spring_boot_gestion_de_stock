package org.example.gestion_de_stock.controller;

import org.example.gestion_de_stock.entity.Product;
import org.example.gestion_de_stock.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")

public class ProductRestController {
    @Autowired
    ProductService productService;

    @PostMapping("/save")
    public Product saveProduct(@RequestBody Product product){
        return  productService.createProduct(product);
    }
    @GetMapping("/all")
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }
    @GetMapping("/getone/{id}")
    public Product getoneProduct(@PathVariable int id){
        return productService.getProductByID(id);
    }
    @PutMapping("/update/{id}")
    public Product updateProduct(@PathVariable int id , @RequestBody Product product) {
        Product p1 = productService.getProductByID(id);
        if (p1 != null) {
            product.setId((long) id);
            return productService.UpdateProduct(product);
        } else {
            throw new RuntimeException("failed!");
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") int id){
        try {
            productService.deleteProduct(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e){
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }


}
