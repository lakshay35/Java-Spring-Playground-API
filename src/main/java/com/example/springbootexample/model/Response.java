package com.example.springbootexample.model;

import org.springframework.http.HttpStatus;

public class Response<T> {
    private T response;
    private String message;
    private HttpStatus statusCode;

    public Response(){

    }

    public Response(T response, String message, HttpStatus statusCode) {
        this.response = response;
        this.message = message;
        this.statusCode = statusCode;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }
}
