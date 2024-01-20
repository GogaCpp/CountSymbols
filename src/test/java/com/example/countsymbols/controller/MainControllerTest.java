package com.example.countsymbols.controller;
import com.example.countsymbols.сontroller.MainController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MainController.class)
class MainControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testConvertEndpoint() throws Exception {

        String value = "13332";


        mockMvc.perform(MockMvcRequestBuilders.get("/count")
                        .param("value", value))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("{\"3\":3,\"1\":1,\"2\":1}"));
    }
}
