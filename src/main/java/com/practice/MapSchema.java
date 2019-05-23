package com.practice;

import java.util.HashMap;

public class MapSchema implements Schema {
    private HashMap<String, String> map = new HashMap<>();
    @Override
    public Object getValue(String value) {
        if (value==null) {
            return new HashMap<String, String>();
        }
        String[] result = value.split(",");
        for (String element: result){
            String[] values = element.split(":");
            map.put(values[0], values[1]);
        }
        return map;
    }
}
