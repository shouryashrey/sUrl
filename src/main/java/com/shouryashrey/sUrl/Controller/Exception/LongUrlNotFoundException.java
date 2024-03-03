package com.shouryashrey.sUrl.Controller.Exception;

public class LongUrlNotFoundException extends RuntimeException {
    public LongUrlNotFoundException(String message) {
        super(message);
    }

    public LongUrlNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public LongUrlNotFoundException(Throwable cause) {
        super(cause);
    }
}
