package com.retail.store.service;

import com.retail.store.entity.Sales;
import com.retail.store.repository.SalesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalesService {

    private final SalesRepository salesRepository;

    public SalesService(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }

    public List<Sales> getAllSales() {
        return salesRepository.findAll();
    }

    public Optional<Sales> getSaleById(Long id) {
        return salesRepository.findById(id);
    }

    public Sales createSale(Sales sale) {
        return salesRepository.save(sale);
    }

    public Sales updateSale(Long id, Sales updatedSale) {
        return salesRepository.findById(id)
                .map(existing -> {
                    existing.setName(updatedSale.getName());
                    existing.setDescription(updatedSale.getDescription());
                    existing.setId(updatedSale.getId());
                    return salesRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Sale not found with id: " + id));
    }

    public void deleteSale(Long id) {
        salesRepository.deleteById(id);
    }
}
