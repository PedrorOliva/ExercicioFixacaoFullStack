package com.catalisa.APIFullStackSupermercado.service;

import com.catalisa.APIFullStackSupermercado.model.ProductModel;
import com.catalisa.APIFullStackSupermercado.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
  @Autowired
  ProductRepository productRepository;

  public ProductModel register(ProductModel productModel) {
    return productRepository.save(productModel);
  }

  public List<ProductModel> listAll() {
    return productRepository.findAll();
  }

  public Optional<ProductModel> listByID(Long id) {
    return productRepository.findById(id);
  }
}
