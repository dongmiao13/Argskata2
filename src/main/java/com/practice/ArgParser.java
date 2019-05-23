package com.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.ListIterator;

public class ArgParser {

    private final HashMap<String, ArgValue> argMap;

    public ArgParser(String config) {
        argMap = new HashMap<>();
        String[] argList = config.split("\\p{Blank}");
        parseArgList(argList);
    }

    private void parseArgList(String[] argList) {
        ListIterator<String> stringListIterator = Arrays.asList(argList).listIterator();
        while(stringListIterator.hasNext()){
            parseArg(stringListIterator);
        }
    }

    private void parseArg(ListIterator<String> stringListIterator) {
        String argName = stringListIterator.next();
        String value = getArgValue(stringListIterator);
        if(isArgName(argName)){
            argMap.put(argName.substring(1), new ArgValue(value));
        }
    }

    private String getArgValue(ListIterator<String> stringListIterator) {
        if(stringListIterator.hasNext()){
            String value = stringListIterator.next();
            if(isArgName(value)){
                stringListIterator.previous();
            }
            return value;
        }
        return null;
    }

    private boolean isArgName(String typeName) {
        if(!typeName.startsWith("-")){
            return false;
        }
        if(typeName.length()!=2){
            return false;
        }
        if(Character.isDigit(typeName.charAt(1))){
            return false;
        }
        return true;
    }

    public String getValue(String key) throws NoArgFoundException {
        ArgValue value = argMap.get(key);
        if(value == null){
            throw new NoArgFoundException();
        }
        return value.getValue();
    }
}
