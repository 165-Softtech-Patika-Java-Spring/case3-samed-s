package com.softtech.case3.converter;

import com.softtech.case3.dto.ProductDto;
import com.softtech.case3.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto convertToProductDto(Product product);

    List<ProductDto> convertToProductDtoList(List<Product> productList);

    Product convertToProduct(ProductDto productDto);

}
