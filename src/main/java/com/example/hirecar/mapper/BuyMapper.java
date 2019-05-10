package com.example.hirecar.mapper;

import com.example.hirecar.bean.Buy;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BuyMapper {
    int addBuy(Buy buy);
    List<Buy> getList(Integer userId);
}
