package com.example.filedemo.exception;

public class FileStorageException extends RuntimeException {
    private static final long serialVersionUID = 5590548883542393370L;

    public FileStorageException(String message) {
        super(message);
    }

    public FileStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
