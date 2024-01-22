package com.example.countsymbols.service;

import com.example.countsymbols.mapper.JsonMapper;
import com.example.countsymbols.mapper.ToJsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.Map;


@Service
public class CountService implements SymbolCounter{

    @Autowired
    JsonMapper toJsonMapper;

    public String countSymbols(String value) {
        if(value==null) return null;
        Map<Character, Integer> charCount = new LinkedHashMap<>();
        for (char c : value.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> sortedMap = new LinkedHashMap<>();
        charCount.entrySet()
                .stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .forEach(entry -> sortedMap.put(entry.getKey(), entry.getValue()));

        return toJsonMapper.mapToJson(sortedMap);
    }
}
