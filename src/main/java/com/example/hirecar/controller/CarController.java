package com.example.hirecar.controller;




import com.example.hirecar.bean.Buy;
import com.example.hirecar.bean.Car;
import com.example.hirecar.bean.Collect;
import com.example.hirecar.param.AddCarParam;
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

    @PostMapping("/addCar")
    public  Response addCar(AddCarParam addCarParam) {
        int row = carService.addCar(addCarParam);
        return new Response(200,"发布成功");
    }
    @PostMapping("/hireCar")
    public Response hireCar(@RequestBody Buy buy) {
        boolean res = carService.hireCar(buy);
        return res ? new Response(200,"租赁成功"): new Response(200,"请勿重复租赁");
    }
    @PostMapping("/collectCar")
    public Response collectCar(@RequestBody Collect collect) {
        boolean res = carService.collectCar(collect);
        return res ? new Response(200,"收藏成功"): new Response(200,"请勿重复收藏");
    }
    @GetMapping("/getCar")
    public Response<Car> getCar(int carId) {
        Car car = carService.getCar(carId);
        return new Response(car);
    }

    @GetMapping("/searchCar")
    public Response<List> searchCar(String str) {
        List<Car> list = carService.searchCar(str);
        return new Response<>(list);
    }

}
