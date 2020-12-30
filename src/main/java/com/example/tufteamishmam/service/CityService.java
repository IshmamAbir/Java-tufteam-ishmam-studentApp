package com.example.tufteamishmam.service;

import com.example.tufteamishmam.dto.CityDto;
import com.example.tufteamishmam.entity.City;
import com.example.tufteamishmam.repository.CityRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
public class CityService implements Serializable {

    CityRepository repo;

    public CityService(CityRepository repo) {
        this.repo = repo;
    }

    public List<CityDto> showAllCity() {
        List<City> cityList=repo.findAll();
        List<CityDto> cityDtoList=new ArrayList<>();
        for (City city:cityList) {
            CityDto cityDto=new CityDto();
            BeanUtils.copyProperties(city,cityDto);
            cityDtoList.add(cityDto);
        }
        return cityDtoList;
    }


}
