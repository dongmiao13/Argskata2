package com.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class ListSchema implements Schema {
    @Override
    public Object getValue(String value) {
        if (value==null){
            return new ArrayList<String>();
        }
        return Arrays.asList(value);
    }
}
