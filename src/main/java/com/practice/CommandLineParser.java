package com.practice;


public class CommandLineParser {

    private final Schemas schema;
    private final ArgParser argParser;

    public CommandLineParser(String config, String values) throws WrongSchemaException {
        schema = new Schemas(config);
        argParser = new ArgParser(values);
    }

    public Object getArg(String key) throws NoArgFoundException {
        return schema.getSchema(key).getValue(argParser.getValue(key));
    }
}
