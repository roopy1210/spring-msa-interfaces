package com.roopy.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class StoreDTO {
    private int id;
    private String nm;
    private String addr;
    private double lat;
    private double lot;
    private double radius;
}
