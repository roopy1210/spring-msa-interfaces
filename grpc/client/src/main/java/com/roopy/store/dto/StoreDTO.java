package com.roopy.store.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class StoreDTO {
    private int id;
    private String nm;
    private String addr;
    private double lat;
    private double lot;
    private int dtnc;
    private int radius;
}
