package com.catalisa.APIFullStackSupermercado.controller;

import com.catalisa.APIFullStackSupermercado.model.ProductModel;
import com.catalisa.APIFullStackSupermercado.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/produtos")
public class ProductController {
  @Autowired
  ProductService productService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @CrossOrigin(origins = "http://127.0.0.1:5500")
  public ResponseEntity<ProductModel> registerNewProduct(@RequestBody ProductModel productModel) {
    return ResponseEntity.ok(productService.register(productModel));
  }

  @GetMapping
  @CrossOrigin(origins = "http://127.0.0.1:5500/")
  public List<ProductModel> listAllProducts() {
    return productService.listAll();
  }

  @GetMapping(path = "/{id}")
  @CrossOrigin(origins = "http://127.0.0.1:5500/")
  public ResponseEntity<Optional<ProductModel>> listById(@PathVariable Long id) {
    return ResponseEntity.ok(productService.listByID(id));
  }
}
