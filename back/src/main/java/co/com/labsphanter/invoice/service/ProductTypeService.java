package co.com.labsphanter.invoice.service;

import co.com.labsphanter.invoice.object.model.ProductType;
import co.com.labsphanter.invoice.repository.ProductTypeRepository;
import co.com.labsphanter.invoice.utilities.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductTypeService {

    @Autowired
    private ProductTypeRepository productTypeRepository;

    public ProductType save(ProductType productType) {

        if(productTypeRepository.findByName(productType.getName()) == null) {
            productType.setId(Utilities.generationId());
            productTypeRepository.save(productType);
        }else {
            productType = new ProductType();
            productType.setMessage("Ya existe un tipo de producto con este nombre.");
        }

        return productType;
    }

    public ProductType update(ProductType productType) {
        productTypeRepository.save(productType);
        return productType;
    }

    public ProductType findById(String id) {
        return Optional.ofNullable(
                productTypeRepository.findById(id))
                .get()
                .orElse(new ProductType());
    }

    public List<ProductType> findAll() {
        return productTypeRepository.findAll();
    }
}
