package com.practice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class SchemaTest {


    @Test
    public void testbool() throws WrongSchemaException {
        Schemas schemas = new Schemas("l:bool");
        Schema schema = schemas.getSchema("l");
        assertNotNull(schema);
        assertEquals(schema.getValue("true"), Boolean.TRUE);
        assertEquals(schema.getValue("false"), Boolean.FALSE);
        assertEquals(schema.getValue(null), Boolean.FALSE);
        assertEquals(schema.getValue(""), Boolean.FALSE);
    }

    @Test
    public void testint() throws WrongSchemaException {
        Schemas schemas = new Schemas("l:int");
        Schema schema = schemas.getSchema("l");
        assertNotNull(schema);
        assertEquals(schema.getValue("100"), new Integer(100));
        assertEquals(schema.getValue(""), new Integer(0));
    }

    @Test
    public void teststring() throws WrongSchemaException {
        Schemas schemas = new Schemas("l:string");
        Schema schema = schemas.getSchema("l");
        assertNotNull(schema);
        assertEquals(schema.getValue("100"), "100");
        assertEquals(schema.getValue(""), "");
        assertEquals(schema.getValue(null), "");
    }

    @Test
    public void testlist() throws WrongSchemaException {
        Schemas schemas = new Schemas("l:list");
        Schema schema = schemas.getSchema("l");
        assertNotNull(schema);
        assertEquals(schema.getValue("1,2,3,4"), Arrays.asList("1,2,3,4"));
        assertEquals(schema.getValue(null), new ArrayList<>());
    }

    @Test
    public void testmap() throws WrongSchemaException {
        Schemas schemas = new Schemas("l:map");
        Schema schema = schemas.getSchema("l");
        assertNotNull(schema);
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("a", "100");
        assertEquals(schema.getValue("a:100"), map);
        assertEquals(schema.getValue(null), new HashMap<>());
    }

    @Test
    public void test_more_schema() throws WrongSchemaException {
        Schemas schemas = new Schemas("l:bool, i:int, s:string");
        Schema boolSchema = schemas.getSchema("l");
        Schema intSchema = schemas.getSchema("i");
        Schema stringSchema = schemas.getSchema("s");
        assertEquals(boolSchema.getValue("true"), true);
        assertEquals(intSchema.getValue("-10"), -10);
        assertEquals(stringSchema.getValue("10"), "10");
    }
}

