package com.konoha.sushi.saledetail.domain;

import java.util.List;

public interface SaleDetailRepository {
    SaleDetail save(SaleDetail saleDetail);
    SaleDetail update(Long id, SaleDetail saleDetail);
    List<SaleDetail> findAll();
    void delet(Long id);
}
