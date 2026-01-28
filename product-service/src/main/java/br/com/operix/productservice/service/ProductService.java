package br.com.operix.productservice.service;

import br.com.operix.productservice.model.Product;
import br.com.operix.productservice.repository.ProductRepository;
import org.apache.hc.core5.http.HttpException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<Product> findAll(Pageable pageable) {
        return this.productRepository.findAll(pageable);
    }

    public Product findById(UUID id) throws HttpException {
        return this.productRepository.findById(id)
                .orElseThrow(() -> new HttpException("Entity not found"));
    }
}
