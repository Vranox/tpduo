package com.example.tpnote;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class TypesDeserializer extends JsonDeserializer<Types> {

    @Override
    public Types deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String value = jsonParser.readValueAs(String.class);
        return Types.valueOf(value.toUpperCase());
    }
}
