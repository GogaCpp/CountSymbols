package com.example.countsymbols.mapper;
import com.example.countsymbols.exception.ConversationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;


@Slf4j
@Component
public class ToJsonMapper implements JsonMapper{
    public String mapToJson(Map<Character, Integer> charCount) throws ConversationException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json;
        try {
            json = objectMapper.writeValueAsString(charCount);
        } catch (JsonProcessingException e) {
            log.error("Conversation error");
            throw new ConversationException("Conversation error",e);
        }
        return json;
    }

}
