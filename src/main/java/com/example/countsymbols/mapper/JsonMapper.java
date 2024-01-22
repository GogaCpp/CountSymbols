package com.example.countsymbols.mapper;

import com.example.countsymbols.exception.ConversationException;

import java.util.Map;

public interface JsonMapper {
    String mapToJson(Map<Character, Integer> charCount) throws ConversationException;
}
