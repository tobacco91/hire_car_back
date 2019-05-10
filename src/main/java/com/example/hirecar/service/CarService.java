package com.example.hirecar.service;

import com.example.hirecar.bean.Buy;
import com.example.hirecar.bean.Car;
import com.example.hirecar.bean.Collect;
import com.example.hirecar.param.AddCarParam;

import java.util.List;

public interface CarService {
    List<Car> hotList();

    int addCar(AddCarParam addCarParam);

    boolean hireCar(Buy buy);

    boolean collectCar(Collect collect);

    Car getCar(int carId);

    List<Car> searchCar(String str);
}
