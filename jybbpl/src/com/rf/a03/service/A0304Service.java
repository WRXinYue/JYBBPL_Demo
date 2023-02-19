package com.rf.a03.service;

import java.util.Map;

public interface A0304Service {
    Map<String, Object> selectByAll();
    Map<String, Object> selectById(Integer paramIdt);

    Map<String, Object> selectByName(String paramName);

    Map<String, Object> selectByAge(String paramAge);
}
