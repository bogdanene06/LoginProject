package Exercitii.mapper;

import Exercitii.DTO.ProductMyUserDTO;
import Exercitii.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMyUserMapper {

    public Product toProductEntity(ProductMyUserDTO productMyUserDTO) {
        Product product = new Product();
        product.setProductName(productMyUserDTO.getProductName());
        product.setProductPrice(productMyUserDTO.getProductPrice());
        return product;
    }


}
