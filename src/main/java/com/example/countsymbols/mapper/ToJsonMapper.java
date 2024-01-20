package com.example.countsymbols.mapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;


@Slf4j
public class ToJsonMapper {
    public static String mapToJson(Map<Character, Integer> charCount) throws MyCustomException{
        ObjectMapper objectMapper = new ObjectMapper();
        String json;
        try {
            json = objectMapper.writeValueAsString(charCount);
        } catch (JsonProcessingException e) {
            log.error("Conversation error");
            throw new MyCustomException ("Conversation error",e);
        }
        return json;
    }
    public static class MyCustomException extends RuntimeException {
        public MyCustomException(String message, Throwable cause) {
            super(message,cause);
        }
    }
}
