package com.stackroute.productservice.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.stackroute.productservice.model.Product;
import com.stackroute.productservice.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/product-service")
public class ProductController {

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @RequestMapping(value = "/product", method= RequestMethod.POST)
    public ResponseEntity<?> createProduct(@RequestParam String productAsJSONString, @RequestParam MultipartFile image1){
        return productServiceImpl.createProduct(productAsJSONString, image1);
    }

    @RequestMapping(value = "/products", method= RequestMethod.GET,
            params = {"pageNumber", "pageSize", "productBrand", "productCategory", "productManufacturedYear", "warrantyStatus", "productPrice", "productDiscount", "productDamageLevel", "location"})
    public ResponseEntity<?> getProducts(@RequestParam int pageNumber,
                                         @RequestParam int pageSize,
                                         @RequestParam String productBrand,
                                         @RequestParam String productCategory,
                                         @RequestParam String productManufacturedYear,
                                         @RequestParam String warrantyStatus,
                                         @RequestParam BigDecimal productPrice,
                                         @RequestParam Float productDiscount,
                                         @RequestParam Float productDamageLevel,
                                         @RequestParam String location){

        return productServiceImpl.getProducts(pageNumber,
                pageSize,
                productBrand,
                productCategory,
                productManufacturedYear,
                warrantyStatus,
                productPrice,
                productDiscount,
                productDamageLevel,
                location);
    }

    @RequestMapping(value = "/product/{id}", method= RequestMethod.GET)
    public ResponseEntity<?> getProductById(@PathVariable UUID id){
        return productServiceImpl.getProductById(id);
    }

    @RequestMapping(value = "/product/{ownerEmail}", method= RequestMethod.GET,
            params = {"pageNumber", "pageSize", "productBrand"})
    public ResponseEntity<?> getProductsByOwnerEmail(@PathVariable String ownerEmail,
                                                     @RequestParam int pageNumber,
                                                     @RequestParam int pageSize,
                                                     @RequestParam String productBrand){
        return productServiceImpl.getProductsByOwnerEmail(ownerEmail, pageNumber, pageSize, productBrand);
    }

    @RequestMapping(value = "/product/{id}", method= RequestMethod.PUT)
    public ResponseEntity<?> updateProductById(@PathVariable UUID id, @RequestParam String productAsJSONString, @RequestParam MultipartFile image1){
        return productServiceImpl.updateProductById(id, productAsJSONString, image1);
    }

    @RequestMapping(value = "/product/{id}", method= RequestMethod.DELETE)
    public ResponseEntity<?> deleteProductById(@PathVariable UUID id){
        return productServiceImpl.deleteProductById(id);
    }

    @RequestMapping(value = "/test", method= RequestMethod.GET,
            params = {"pageNumber", "pageSize", "productBrand"})
    public void test(@RequestParam int pageNumber,
                     @RequestParam int pageSize,
                     @RequestParam String[] productBrand){
        for(int i=0; i<productBrand.length; i++){
            System.out.println(productBrand[i]);
        }
    }
}
