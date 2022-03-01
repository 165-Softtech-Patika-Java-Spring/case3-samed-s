package com.softtech.case3.service.entityservice;

import com.softtech.case3.dao.ProductDao;
import com.softtech.case3.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductEntityService {
    private final ProductDao productDao;

    public Product save(Product product) {
        return productDao.save(product);
    }

    public List<Product> findAll() {
        return productDao.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productDao.findById(id);
    }

    /**
     * This method finds product by id with control.
     * If there is no product related to the id, an exception appears.
     */
    public Product findByIdWithControl(Long id) {
        Optional<Product> productOptional = findById(id);
        Product product;
        if(productOptional.isPresent()) {
            product = productOptional.get();
        }
        else {
            throw new RuntimeException("Product not found!");
        }
        return product;
    }

    public void delete(Product product) {
        productDao.delete(product);
    }
}
