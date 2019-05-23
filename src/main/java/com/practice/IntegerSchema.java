package com.practice;

public class IntegerSchema implements Schema {
    @Override
    public Integer getValue(String value) {
        if (value == null || value.length() < 1) {
            return new Integer(0);
        }
        return Integer.valueOf(value);
    }
}
