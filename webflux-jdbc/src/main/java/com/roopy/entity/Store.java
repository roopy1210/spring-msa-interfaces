package com.roopy.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "store")
@Data
public class Store {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nm", nullable = false)
    private String nm;

    @Column(name = "addr", nullable = false)
    private String addr;

    @Column(name = "lat", nullable = false)
    private double lat;

    @Column(name = "lot", nullable = false)
    private double lot;

    @Transient
    private int dtnc;
}
