package com.example.hirecar.mapper;

import com.example.hirecar.bean.Release;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReleaseMapper {
    int addRelease(Release release);
    List<Release> getList(Integer userId);
}
