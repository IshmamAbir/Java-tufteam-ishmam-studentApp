package com.example.tufteamishmam.service;

import com.example.tufteamishmam.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class CityService implements Serializable {
    CityRepository cityRepo;

    public CityService(CityRepository cityRepo) {
        this.cityRepo = cityRepo;
    }

    
}
