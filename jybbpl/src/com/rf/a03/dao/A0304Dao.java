package com.rf.a03.dao;

import com.rf.common.model.Course;

import java.util.List;

public interface A0304Dao {
    List<Course> selectByAll();


    List<Course> selectById(Integer paramIdt);

    List<Course> selectByName(String paramName);

    List<Course> selectByAge(String paramAge);
}
