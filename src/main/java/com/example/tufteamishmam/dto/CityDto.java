package com.example.tufteamishmam.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import java.io.Serializable;

@Data
@NoArgsConstructor
@ToString
public class CityDto implements Serializable {
    private long cityId;
    private String cityName;
    private String cityCode;
}
