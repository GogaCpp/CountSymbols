package com.example.countsymbols.mapper;
import com.example.countsymbols.exception.ConversationException;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class ToJsonMapperTest {

    @Test
    void testMapToJson_WithValidInput() {
        Map<Character, Integer> charCount = new HashMap<>();
        charCount.put('a', 2);
        ToJsonMapper toJsonMapper=new ToJsonMapper();
        String result = toJsonMapper.mapToJson(charCount);
        assertEquals("{\"a\":2}", result);
    }

    @Test
    void testMapToJson_WithInvalidInput() {
        Map<Character, Integer> invalidInput = new HashMap<>();
        invalidInput.put(null, 2); // This will cause JsonProcessingException

        ToJsonMapper toJsonMapper=new ToJsonMapper();
        ConversationException exception = assertThrows(ConversationException.class, () -> {
            toJsonMapper.mapToJson(invalidInput);
        });
        assertEquals("Conversation error", exception.getMessage());
    }

    @Test
    void testMapToJson_WithNullInput() {

        Map<Character, Integer> invalidInput = new HashMap<>();
        invalidInput.put(null, 2);
        ToJsonMapper toJsonMapper=new ToJsonMapper();
        assertThrows(ConversationException.class, () -> {
            toJsonMapper.mapToJson(invalidInput);
        });
    }
}

