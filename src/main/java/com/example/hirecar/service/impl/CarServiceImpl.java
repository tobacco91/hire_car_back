package com.example.hirecar.service.impl;

import com.example.hirecar.bean.Car;
import com.example.hirecar.mapper.CarMapper;
import com.example.hirecar.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarMapper carMapper;

    @Override
    public List<Car> hotList() {
        List<Car> list =  carMapper.getListLimit(10);
        return list;
    }
}
