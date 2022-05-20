package com.freelance.exceptions;

/**
 * @author - Akash
 * @date - 19-05-2022
 * @project - E-Freelance-Website
 */
public class ProjectNotFoundException extends RuntimeException{
    public ProjectNotFoundException() {
    }

    /**
     *
     * @param message
     */
    public ProjectNotFoundException(String message) {
        super(message);
    }
}
