package com.lambdaschool.schools.models;

public class ValidationError
{
    public String code;  //password, email, etc. ; validation component that caused issue
    private String message; //explains what the problem is.

    public ValidationError() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
