package com.stackroute.productservice.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;



public interface ProductImageService {
    ResponseEntity<?> addProductImage(MultipartFile file);
//    ResponseEntity<?> deleteProductImageById(UUID productImageId);
//    ResponseEntity<?> deleteProductImage(UUID productId);
//    ResponseEntity<?> getImagesOfProduct(UUID productId);
//    ResponseEntity<?>
}