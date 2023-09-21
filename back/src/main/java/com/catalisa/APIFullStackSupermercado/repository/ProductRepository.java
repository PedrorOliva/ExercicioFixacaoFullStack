package com.catalisa.APIFullStackSupermercado.repository;

import com.catalisa.APIFullStackSupermercado.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {
}
