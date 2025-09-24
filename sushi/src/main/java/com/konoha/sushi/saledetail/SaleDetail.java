package com.konoha.sushi.saledetail;

import com.konoha.sushi.sale.Sale;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "sale-detail")
@Data
public class SaleDetail {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String productName;
    private Integer quantity;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "sale_id",nullable = false)
    private Sale sale;

}
