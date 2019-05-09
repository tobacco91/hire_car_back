package com.example.hirecar.controller;




import com.example.hirecar.bean.Car;
import com.example.hirecar.service.CarService;
import com.example.hirecar.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    CarService carService;

    @GetMapping("/hotList")
    public Response<List<Car>> hotList() {
        List<Car> list = carService.hotList();
        return new Response<>(list);
    }



}
