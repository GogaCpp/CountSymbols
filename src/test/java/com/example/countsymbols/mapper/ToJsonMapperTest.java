package com.example.countsymbols.mapper;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class ToJsonMapperTest {

    @Test
    void testMapToJson_WithValidInput() {
        // Arrange
        Map<Character, Integer> charCount = new HashMap<>();
        charCount.put('a', 2);

        // Act
        String result = ToJsonMapper.mapToJson(charCount);

        // Assert
        assertEquals("{\"a\":2}", result);
    }

    @Test
    void testMapToJson_WithInvalidInput() {

        Map<Character, Integer> invalidInput = new HashMap<>();
        invalidInput.put(null, 2); // This will cause JsonProcessingException


        ToJsonMapper.MyCustomException exception = assertThrows(ToJsonMapper.MyCustomException.class, () -> {
            ToJsonMapper.mapToJson(invalidInput);
        });
        assertEquals("Conversation error", exception.getMessage());
    }

    @Test
    void testMapToJson_WithNullInput() {

        Map<Character, Integer> invalidInput = new HashMap<>();
        invalidInput.put(null, 2);
        // Act & Assert
        assertThrows(ToJsonMapper.MyCustomException.class, () -> {
            ToJsonMapper.mapToJson(invalidInput);
        });
    }
}

