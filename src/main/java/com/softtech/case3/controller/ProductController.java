package com.softtech.case3.controller;

import com.softtech.case3.dto.ProductDto;
import com.softtech.case3.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    
    @PostMapping
    public ResponseEntity save(@RequestBody ProductDto productDto) {
        productDto = productService.save(productDto);
        return ResponseEntity.ok(productDto);
    }

    @GetMapping
    public ResponseEntity findAll() {
        List<ProductDto> productDtoList = productService.findAll();
        return ResponseEntity.ok(productDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        ProductDto productDto = productService.findById(id);
        return ResponseEntity.ok(productDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.ok(Void.TYPE);
    }

    @PatchMapping("/{id}")
    public ResponseEntity updatePrice(@PathVariable Long id, @RequestParam("price") BigDecimal price) {
        ProductDto productDto = productService.updatePrice(id, price);
        return ResponseEntity.ok(productDto);
    }
}
