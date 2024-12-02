package Exercitii.mapper;

import Exercitii.DTO.ProductMyUserDTO;
import Exercitii.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductMyUserDTO toDTO(Product product) {
        ProductMyUserDTO productMyUserDTO = new ProductMyUserDTO();
        productMyUserDTO.setProductPrice(product.getProductPrice());
        productMyUserDTO.setProductName(product.getProductName());
        return productMyUserDTO;
    }
}
