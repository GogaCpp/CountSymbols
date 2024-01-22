package com.example.countsymbols.controller;
import com.example.countsymbols.service.SymbolCounter;
import com.example.countsymbols.сontroller.MainController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MainController.class)
class MainControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SymbolCounter symbolCounter;

    @Test
    void testConvertEndpoint() throws Exception {
        String value = "test";
        when(symbolCounter.countSymbols(value)).thenReturn("{\"t\":1, \"e\":1, \"s\":1}");
        mockMvc.perform(get("/count").param("value", value))
                .andExpect(status().isOk());
    }

    @Test
    void testConvertEndpointWithNull() throws Exception {
        String value = null;
        mockMvc.perform(get("/count").param("value", value))
                .andExpect(status().isBadRequest());
    }
}
