package com.example.library_management.exception;



public class InvalidDataException extends RuntimeException {
    public InvalidDataException(String message) {
        super(message);
    }
}