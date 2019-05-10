package com.example.hirecar.param;

import com.example.hirecar.bean.Car;
import org.springframework.web.multipart.MultipartFile;

public class AddCarParam extends Car {
    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    private MultipartFile image;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    private int userId;
}
