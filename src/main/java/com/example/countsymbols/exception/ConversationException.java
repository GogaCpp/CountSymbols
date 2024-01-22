package com.example.countsymbols.exception;

public class ConversationException extends RuntimeException {
    public ConversationException(String message, Throwable cause) {
        super(message,cause);
    }
}
