package com.shinn.model;

import lombok.*;

import java.sql.Timestamp;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AbstractModel {
    private Long id;
    private Timestamp createdDate;
    private Timestamp modifiedDate;
    private String createdBy;
    private String modifiedBy;
    private Long[] ids;
}
