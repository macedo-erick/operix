package br.com.operix.productservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table
public class Product {

    @Id
    private UUID id;
    private String name;
    private Double price;
}
