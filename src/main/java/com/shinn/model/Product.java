package com.shinn.model;

import lombok.*;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Product extends AbstractModel<Product>{
    private String name;
    private String descrip;
    private String details;
    private Double price;
    private Double discount;
    private Long brandId;
    private String note;
}
