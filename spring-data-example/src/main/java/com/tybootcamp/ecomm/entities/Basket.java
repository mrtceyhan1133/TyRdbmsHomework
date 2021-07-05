package com.tybootcamp.ecomm.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "baskets")
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "basket", orphanRemoval = true)
    @JoinColumn(nullable = false)
    @MapsId
    @JsonIgnore
    private Customer customer;

    List<Product> productList;

    private float totalPrice;
    private int productCount;

    public long getId() {
        return id;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public float getTotalPrice() {
        return totalPrice;
    }
}
