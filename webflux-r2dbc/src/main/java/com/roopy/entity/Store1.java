package com.roopy.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@ToString
@Table(name = "store1")
public class Store1 {

    @Id
    private Integer id;
    private String nm;
    private String addr;
    private double lat;
    private double lot;
    private int dtnc;
}
