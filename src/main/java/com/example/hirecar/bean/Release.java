package com.example.hirecar.bean;

public class Release extends Car {
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }


    private int userId;
    private int carId;
    private int releasesId;

    public int getReleasesId() {
        return releasesId;
    }

    public void setReleasesId(int releasesId) {
        this.releasesId = releasesId;
    }
}
