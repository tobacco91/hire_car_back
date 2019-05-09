package com.example.hirecar.mapper;

import com.example.hirecar.bean.Car;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CarMapper {
    List<Car> getListLimit(int count);
}
