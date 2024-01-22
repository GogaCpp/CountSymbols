package com.example.countsymbols.service;
import com.example.countsymbols.exception.ConversationException;
import com.example.countsymbols.mapper.JsonMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CountServiceTest {
    @Mock
    private JsonMapper jsonMapper;

    @InjectMocks
    private CountService countService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCountSymbols() throws ConversationException {
        String value = "test";
        when(jsonMapper.mapToJson(any())).thenReturn("{\"t\":1, \"e\":1, \"s\":1}");

        String result = countService.countSymbols(value);

        assertEquals("{\"t\":1, \"e\":1, \"s\":1}", result);
    }

    @Test
    public void testCountSymbolsWithNull() {
        String value = null;

        String result = countService.countSymbols(value);

        assertNull(result);
    }
}
