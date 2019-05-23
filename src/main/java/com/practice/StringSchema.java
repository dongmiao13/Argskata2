package com.practice;

public class StringSchema implements Schema {
    @Override
    public Object getValue(String value) {
        if (value == null){
            return "";
        }
        return value;
    }
}
