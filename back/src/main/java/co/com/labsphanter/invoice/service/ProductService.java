package co.com.labsphanter.invoice.service;

import co.com.labsphanter.invoice.object.model.Product;
import co.com.labsphanter.invoice.repository.ProductRepository;
import co.com.labsphanter.invoice.utilities.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product save(Product product) {

        if(productRepository.findByName(product.getName()) == null) {
            product.setId(Utilities.generationId());
            productRepository.save(product);
        }else {
            product = new Product();
            product.setMessage("Ya existe un producto con ese nombre");
        }

        return product;
    }

    public Product update(Product product) {
        productRepository.save(product);
        return product;
    }

    public Product findById(String id) {
        return Optional.ofNullable(
                productRepository.findById(id))
            .get()
            .orElse(new Product());
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
