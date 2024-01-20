package com.example.countsymbols.сontroller;

import com.example.countsymbols.service.CountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController

public class MainController {

    @GetMapping("/count")
    public String convert( @RequestParam("value") String value){

        return CountService.countSymbols(value);
    }
}
