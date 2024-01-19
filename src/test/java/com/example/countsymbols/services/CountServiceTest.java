package com.example.countsymbols.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CountServiceTest {
    @Test
    void CountSymbolsIfNull(){
        String string=CountService.CountSymbols(null);
        Assertions.assertEquals(string,null);
    }
    @Test
    void CountSymbolsIfOne(){
        String string=CountService.CountSymbols("1");
        Assertions.assertEquals(string,"[ 1 : 1 ] ");
    }
}
