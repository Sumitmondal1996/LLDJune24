package com.scaler.lldjun24.DesignPattern.Prototype;

import java.util.HashMap;
import java.util.Map;

public class StudentRegistry {
    private Map<String, Object> map;
    StudentRegistry() {
        map = new HashMap<>();
    }
    public void register(String key, Student student) {
        map.put(key, student);
    }
    public Student get(String key) {
        return (Student) map.get(key);
    }
}
