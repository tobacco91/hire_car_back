package com.example.hirecar.service.impl;

import com.example.hirecar.PDO.CarPDO;
import com.example.hirecar.bean.Buy;
import com.example.hirecar.bean.Car;

import com.example.hirecar.bean.Collect;
import com.example.hirecar.bean.Release;
import com.example.hirecar.mapper.BuyMapper;
import com.example.hirecar.mapper.CarMapper;
import com.example.hirecar.mapper.CollectMapper;
import com.example.hirecar.mapper.ReleaseMapper;
import com.example.hirecar.param.AddCarParam;
import com.example.hirecar.service.CarService;
import com.example.hirecar.util.Encryption;
import com.example.hirecar.util.FatherTochild;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarMapper carMapper;
    @Autowired
    private BuyMapper buyMapper;
    @Autowired
    private CollectMapper collectMapper;
    @Autowired
    private ReleaseMapper releaseMapper;

    @Override
    public List<Car> hotList() {
        List<Car> list =  carMapper.getListLimit(10);
        return list;
    }

    @Override
    public int addCar(AddCarParam addCarParam) {
        String filename = Math.random() + addCarParam.getImage().getOriginalFilename();
        String defaultPath = "/Users/mac/Desktop/carImage/";
        String path = defaultPath + filename;
        File dest = new File(path);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            addCarParam.getImage().transferTo(dest);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        addCarParam.setImagePath(path);
        int row = carMapper.addCar(addCarParam);
        System.out.println(addCarParam.getCarId());
        Release release = new Release();
        release.setCarId(addCarParam.getCarId());
        release.setUserId(addCarParam.getUserId());
        releaseMapper.addRelease(release);
        return row;
    }

    @Override
    public boolean hireCar(Buy buy) {
        Buy res = buyMapper.selectBuy(buy);
        if(res == null) {
            carMapper.updateCarBuyStatus(buy.getCarId());
            buyMapper.addBuy(buy);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean collectCar(Collect collect) {
        Collect res = collectMapper.selectCollect(collect);
        if(res == null) {
            collectMapper.addCollect(collect);
            return true;
        } else {
            return false;
        }



    }

    @Override
    public CarPDO getCar(int carId) {
        Car car = carMapper.getCar(carId);
        CarPDO carPDO = new CarPDO();
        try {
            FatherTochild.fatherToChild(car,carPDO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String price = car.getPrice()+ "";
        Encryption encryption = new Encryption(price.getBytes());
        carPDO.setCode(encryption.getCrc());
        carPDO.setStringPrice(price);
        carMapper.addBrowsTimes(carId);

        return carPDO;
    }

    @Override
    public List<Car> searchCar(String str) {
        List<Car> list = carMapper.selectTitle("%" + str + "%");
        return list;
    }
}
