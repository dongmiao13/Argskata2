package com.practice;

import java.util.HashMap;
import java.util.Map;

public class Schemas {
    Map<String, Schema> schemaMap;

    public Schemas(String config) throws WrongSchemaException {
        schemaMap = new HashMap<>();
        String[] result = config.split(",");
        parseSchemas(result);
    }

    private void parseSchemas(String[] splitSchemas) throws WrongSchemaException {
        for (int i = 0; i<splitSchemas.length; i++){
            parseSchema(splitSchemas[i].trim());
        }
    }

    private void parseSchema(String splitSchema) throws WrongSchemaException {
        String[] typeValue = splitSchema.split(":");
        Schema schema = getSchemaType(typeValue[1]);
        schemaMap.put(typeValue[0], schema);
    }

    private Schema getSchemaType(String value) throws WrongSchemaException {
        switch (value){
            case "bool":
                return new BoolSchema();
            case "int":
                return new IntegerSchema();
            case "string":
                return new StringSchema();
            case "list":
                return new ListSchema();
            case "map":
                return new MapSchema();
        }
        throw new WrongSchemaException();
    }

    public Schema getSchema(String l) {
        return schemaMap.get(l);
    }
}
