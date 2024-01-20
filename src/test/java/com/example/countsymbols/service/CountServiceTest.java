package com.example.countsymbols.service;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CountServiceTest {
    @Test
    void testCountSymbolsWithNullInput() {
        assertNull(CountService.countSymbols(null));
    }
    @Test
    void CountSymbolsIfEmpty(){
        String string=CountService.countSymbols("");
        assertEquals(string, "{}");
    }
    @Test
    void CountSymbolsIfOne(){
        String string=CountService.countSymbols("1");
        assertEquals(string,"{\"1\":1}");
    }

    @Test
    void CountSymbolsIsSort(){
        String string=CountService.countSymbols("133322");
        assertEquals(string,"{\"3\":3,\"2\":2,\"1\":1}");

    }
    @Test
    void CountSymbolsIsSortAndSameCount(){
        String string=CountService.countSymbols("13332");
        assertEquals(string,"{\"3\":3,\"1\":1,\"2\":1}");

    }
    @Test
    void testCountSymbolsWithSpecialCharacters() {
        String input = "#$%^&";
        String expectedOutput = "{\"#\":1,\"$\":1,\"%\":1,\"^\":1,\"&\":1}";
        assertEquals(expectedOutput, CountService.countSymbols(input));
    }
}
