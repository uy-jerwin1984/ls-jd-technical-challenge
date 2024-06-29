package com.ph.juy.ls.exceptions;

public class SpeechNotFoundException extends BusinessException {
    public SpeechNotFoundException() {
    }

    public SpeechNotFoundException(String message) {
        super(message);
    }

    public SpeechNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SpeechNotFoundException(Throwable cause) {
        super(cause);
    }
}
