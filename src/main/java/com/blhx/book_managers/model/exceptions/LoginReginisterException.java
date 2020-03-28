package com.blhx.book_managers.model.exceptions;

public class LoginReginisterException extends RuntimeException {
    public LoginReginisterException ( ){
        super();
    }

    public LoginReginisterException ( String message ){
        super(message);
    }

    public LoginReginisterException ( String message, Throwable cause ){
        super(message, cause);
    }

    public LoginReginisterException ( Throwable cause ){
        super(cause);
    }

}
