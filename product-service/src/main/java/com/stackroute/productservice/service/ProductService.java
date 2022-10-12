package com.stackroute.productservice.service;

import com.stackroute.productservice.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.UUID;

public interface ProductService {
    ResponseEntity<String> createProduct(String product, MultipartFile image1);
    ResponseEntity<?> getProducts(int pageNumber,
                                  int pageSize,
                                  String productBrand,
                                  String productCategory,
                                  String productManufacturedYear,
                                  String warrantyStatus,
                                  BigDecimal productPrice,
                                  Float productDiscount,
                                  Float productDamageLevel,
                                  String location);
    ResponseEntity<Product> getProductById(UUID id);
    ResponseEntity<String> updateProductById(UUID id, String productAsJSONString, MultipartFile image1);
    ResponseEntity<String> deleteProductById(UUID id);
    ResponseEntity<?> getProductsByOwnerEmail(String ownerEmail, int pageNumber, int pageSize, String productBrand);
}
