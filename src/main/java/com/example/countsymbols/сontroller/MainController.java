package com.example.countsymbols.сontroller;

import com.example.countsymbols.service.CountService;
import com.example.countsymbols.service.SymbolCounter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController

public class MainController {

    @Autowired
    SymbolCounter symbolCounter;

    @GetMapping("/count")
    public String convert( @RequestParam(value = "value", required = true)  String value){
        return symbolCounter.countSymbols(value);
    }
}
