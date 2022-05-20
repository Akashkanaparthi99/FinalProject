package com.freelance.exceptions;

/**
 * @author - Akash
 * @Date - 16-05-2022
 */
public class ClientNotFoundException extends RuntimeException{
    public ClientNotFoundException() {
    }

    /**
     *
     * @param message
     */
    public ClientNotFoundException(String message) {
        super(message);
    }
}
