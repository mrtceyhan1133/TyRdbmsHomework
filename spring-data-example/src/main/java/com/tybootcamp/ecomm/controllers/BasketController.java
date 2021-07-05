package com.tybootcamp.ecomm.controllers;

import com.tybootcamp.ecomm.entities.Basket;
import com.tybootcamp.ecomm.entities.Product;
import com.tybootcamp.ecomm.repositories.BasketRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/baskets")
public class BasketController {
    BasketRepository basketRepository;
    public BasketController(BasketRepository basketRepository){this.basketRepository = basketRepository; }

    @GetMapping(path = "/")
    public ResponseEntity<?> AddProductToBasket(Product product, Basket basket)
    {
        if(product == null)
        {
            return new ResponseEntity<>(
                    "There isn't any Product to add ", HttpStatus.NOT_FOUND);
        }
        var productList = basket.getProductList();
        productList.add(product);
        basket.setProductList(productList);
        var productCount = basket.getProductCount();
        basket.setProductCount(productCount++);
        var totalPrice = basket.getTotalPrice();
        basket.setTotalPrice(totalPrice+product.getPrice());
        return new ResponseEntity<>("The Product added to basked", HttpStatus.OK);
    }

    @GetMapping(path = "/")
    public ResponseEntity<?> RemoveProductToBasket(Product product, Basket basket)
    {
        if(product == null)
        {
            return new ResponseEntity<>(
                    "There isn't any Product to remove ", HttpStatus.NOT_FOUND);
        }
        var productList = basket.getProductList();
        productList.remove(product);
        basket.setProductList(productList);
        var productCount = basket.getProductCount();
        basket.setProductCount(productCount--);
        var totalPrice = basket.getTotalPrice();
        basket.setTotalPrice(totalPrice-product.getPrice());
        return new ResponseEntity<>("The Product remove to basked", HttpStatus.OK);
    }

}
