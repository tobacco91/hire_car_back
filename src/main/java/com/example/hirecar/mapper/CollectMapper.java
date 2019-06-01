package com.example.hirecar.mapper;

import com.example.hirecar.bean.Collect;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CollectMapper {
    int addCollect(Collect collect);
    List<Collect> getList(int userId);
    Collect selectCollect(Collect collect);
}
