package com.softtech.case3.service;

import com.softtech.case3.converter.ProductMapper;
import com.softtech.case3.dto.ProductDto;
import com.softtech.case3.entity.Product;
import com.softtech.case3.service.entityservice.ProductEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductEntityService productEntityService;

    public ProductDto save(ProductDto productDto) {
        Product product = ProductMapper.INSTANCE.convertToProduct(productDto);
        product = productEntityService.save(product);
        ProductDto resultProductDto = ProductMapper.INSTANCE.convertToProductDto(product);
        return resultProductDto;
    }

    public List<ProductDto> findAll() {
        List<Product> productList = productEntityService.findAll();
        List<ProductDto> productDtoList = ProductMapper.INSTANCE.convertToProductDtoList(productList);
        return productDtoList;
    }

    public ProductDto findById(Long id) {
        Product product = productEntityService.findByIdWithControl(id);
        ProductDto productDto = ProductMapper.INSTANCE.convertToProductDto(product);
        return productDto;
    }

    public void delete(Long id) {
        Product product = productEntityService.findByIdWithControl(id);
        productEntityService.delete(product);
    }

    public ProductDto updatePrice(Long id, BigDecimal price) {
        Product product = productEntityService.findByIdWithControl(id);
        product.setPrice(price);
        product = productEntityService.save(product);

        ProductDto productDto = ProductMapper.INSTANCE.convertToProductDto(product);
        return productDto;
    }
}
