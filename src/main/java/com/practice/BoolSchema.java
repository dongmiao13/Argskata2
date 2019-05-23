package com.practice;

public class BoolSchema implements Schema {
    public Boolean getValue(String value){
        if(value!=null && value !="false" && value.length()!=0){
            return true;
        }
        return false;
    }
}
