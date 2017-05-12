package com.javarush.task.task33.task3304;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Map;

/* 
Конвертация из одного класса в другой используя JSON
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Second s = (Second) convertOneToAnother(new First(), Second.class);
        First f = (First) convertOneToAnother(new Second(), First.class);
    }

    public static Object convertOneToAnother(Object one, Class resultClassObject) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        StringWriter stringWriter = new StringWriter();
        mapper.writeValue(stringWriter, one);

        JsonNode jsonNode = mapper.reader().readTree(stringWriter.toString());

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> result = objectMapper.convertValue(jsonNode, Map.class);
        String key = result.keySet().toArray()[0].toString();

        com.fasterxml.jackson.databind.node.ObjectNode objectNode = (com.fasterxml.jackson.databind.node.ObjectNode)jsonNode;

        objectNode.put(key, resultClassObject.getSimpleName().toLowerCase());

        StringReader stringReader = new StringReader(objectNode.toString());
        return objectMapper.readValue(stringReader, resultClassObject);
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME,  property="className")
    @JsonSubTypes(@JsonSubTypes.Type(value=First.class,  name="first"))
    public static class First {
        public int i;
        public String name;
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME,  property="className")
    @JsonSubTypes(@JsonSubTypes.Type(value=Second.class, name="second"))
    public static class Second {
        public int i;
        public String name;
    }
}
