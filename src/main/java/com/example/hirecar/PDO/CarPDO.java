package com.example.hirecar.PDO;

import com.example.hirecar.bean.Car;

public class CarPDO extends Car {
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String code;

    public String getStringPrice() {
        return stringPrice;
    }

    public void setStringPrice(String stringPrice) {
        this.stringPrice = stringPrice;
    }

    private String stringPrice;
}
