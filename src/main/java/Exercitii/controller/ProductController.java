package Exercitii.controller;

import Exercitii.DTO.MyUserDTO;
import Exercitii.DTO.ProductMyUserDTO;
import Exercitii.entity.MyUser;
import Exercitii.entity.Product;
import Exercitii.mapper.ProductMapper;
import Exercitii.mapper.ProductMyUserMapper;
import Exercitii.repository.MyUserRepository;
import Exercitii.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/product")
public class ProductController {

    private final ProductRepository productRepository;
    private final MyUserRepository myUserRepository;
    private final ProductMyUserMapper productMyUserMapper;
    private final ProductMapper productMapper;

    @PostMapping(value = "/all")
    public ResponseEntity<?> getAllProducts(@RequestBody MyUserDTO myUserDTO) {
        Optional<MyUser> databaseUser = myUserRepository.findByUsername(myUserDTO.getUsername());
        if (databaseUser.isPresent()) {
            BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
            boolean passwordMatches = bcrypt.matches(myUserDTO.getPassword(), databaseUser.get().getPassword());
            if (passwordMatches) {
                if (databaseUser.get().getRole().equals("user")) {
                    List<Product> allProducts = productRepository.findAllProductsForUser();
                    List<ProductMyUserDTO> allProductsDTO = allProducts
                            .stream()
                            .map(productMapper::toDTO)
                            .toList();
                    return new ResponseEntity<>(allProductsDTO, HttpStatus.OK);
                } else {
                    List<Product> allProducts = productRepository.findAll();
                    List<ProductMyUserDTO> allProductsDTO = allProducts
                            .stream()
                            .map(productMapper::toDTO)
                            .toList();
                    return new ResponseEntity<>(allProductsDTO, HttpStatus.OK);
                }
            } else {
                return new ResponseEntity<>("Password is incorrect.", HttpStatus.FORBIDDEN);
            }
        } else {
            return new ResponseEntity<>("Username not found.", HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> saveProduct(@RequestBody ProductMyUserDTO productUserDTO) {
        Optional<MyUser> databaseUser = myUserRepository.findByUsername(productUserDTO.getUsername());
        if (databaseUser.isPresent()) {
            BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
            boolean passwordMatches = bcrypt.matches(productUserDTO.getPassword(), databaseUser.get().getPassword());
            if (passwordMatches) {
                if (databaseUser.get().getRole().equals("admin")) {
                    return new ResponseEntity<>(
                            productRepository.save(productMyUserMapper.toProductEntity(productUserDTO)),
                            HttpStatus.OK
                    );
                } else {
                    return new ResponseEntity<>("Only admin can insert products.", HttpStatus.FORBIDDEN);
                }
            } else {
                return new ResponseEntity<>("Password is incorrect.", HttpStatus.FORBIDDEN);
            }
        } else {
            return new ResponseEntity<>("Username not found.", HttpStatus.FORBIDDEN);
        }
    }

}
