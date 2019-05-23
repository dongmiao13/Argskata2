package com.practice;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;


@RunWith(JUnit4.class)
public class ArgParserTest {

    @Before
    public void setup() {

    }
    @Test
    public void test_one_value() throws NoArgFoundException {
        ArgParser argParser = new ArgParser("-b true");
        assertEquals(argParser.getValue("b"), "true");
    }

    @Test
    public void test_negative() throws NoArgFoundException {
        ArgParser argParser = new ArgParser("-l -1");
        assertEquals(argParser.getValue("l"), "-1");
    }

    @Test
    public void test_more() throws NoArgFoundException {
        ArgParser argParser = new ArgParser("-b true -p 8080 -s string -l 1,2,3,4 -m a:b,c:d -n -1");
        assertEquals(argParser.getValue("b"), "true");
        assertEquals(argParser.getValue("p"), "8080");
        assertEquals(argParser.getValue("s"), "string");
        assertEquals(argParser.getValue("l"), "1,2,3,4");
        assertEquals(argParser.getValue("m"), "a:b,c:d");
        assertEquals(argParser.getValue("n"), "-1");
    }
}

