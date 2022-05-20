package com.freelance.exceptions;

/**
 * @author - Akash
 * @date - 19-05-2022
 * @project - E-Freelance-Website
 */
public class NoBiddingException extends RuntimeException{

    public NoBiddingException() {
    }

    /**
     *
     * @param message
     */
    public NoBiddingException(String message) {
        super(message);
    }
}
