package com.acme.wheelmanagerserversidemovil.domain.service;

import com.acme.wheelmanagerserversidemovil.domain.model.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ProductCategoryService {
    Page<ProductCategory> getAllProductCategoriesByProductId(Long productId, Pageable pageable);
    ProductCategory getProductCategoryByIdAndProductId(Long productCategoryId, Long productId);
    ResponseEntity<?> deleteProductCategory(Long productCategoryId);
    ProductCategory updateProductCategory(Long productCategoryId, ProductCategory productCategoryRequest);
    ProductCategory createProductCategory(ProductCategory productCategoryRequest);
    ProductCategory getProductCategoryById(Long productCategoryId);
    Page<ProductCategory> getAllProductCategories(Pageable pageable);
}
