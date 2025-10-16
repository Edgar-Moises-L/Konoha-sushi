package com.konoha.sushi.sale.domain;

import java.util.List;

public interface SaleService {
    Sale save(Sale sale);
    Sale update(Long id, Sale sale);
    List<Sale> findAll();
    Sale findById(Long id);
}
