package com.practice;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.*;


@RunWith(JUnit4.class)
public class CommandLineTest {

    @Before
    public void setup() {

    }

    @Test
    public void test() throws WrongSchemaException, NoArgFoundException {
        CommandLineParser commandLine = new CommandLineParser("l:bool, p:int, d:string, t:list, m:map","-l true -p 8080 -d /usr/bin -t 1,2,3,4 -m a:b");
        assertEquals(commandLine.getArg("l"),true);
        assertEquals(commandLine.getArg("p"),8080);
        assertEquals(commandLine.getArg("d"),"/usr/bin");
        assertEquals(commandLine.getArg("t"), Arrays.asList("1,2,3,4"));
        HashMap<String, String> map = new HashMap<>();
        map.put("a","b");
        assertEquals(commandLine.getArg("m"), map);
    }
}

