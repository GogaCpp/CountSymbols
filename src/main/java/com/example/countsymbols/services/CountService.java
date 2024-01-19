package com.example.countsymbols.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class CountService {

    public static String CountSymbols(String value){

        if(value==null) return null;
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : value.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        StringBuilder result= new StringBuilder();
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            log.info(entry.getKey() + " : " + entry.getValue());
            result.append("[ ").append(entry.getKey()).append(" : ").append(entry.getValue()).append(" ] ");

        }

        return result.toString();
    }
}
