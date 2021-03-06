package com.example.hirecar.mapper;

import com.example.hirecar.bean.Car;
import com.example.hirecar.param.AddCarParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CarMapper {
    List<Car> getListLimit(int count);

    int addCar(AddCarParam addCarParam);

    int updateCarBuyStatus(int carId);

    Car getCar(int carId);

    List<Car> selectTitle(String title);

    int addBrowsTimes(int carId);
}
