package com.freelance.exceptions;

/**
 * @author - Akash
 * @Date - 16-05-2022
 */
public class FreelanceNotFoundException extends RuntimeException{
    public FreelanceNotFoundException() {
    }

    /**
     *
     * @param message
     */
    public FreelanceNotFoundException(String message) {
        super(message);
    }
}
