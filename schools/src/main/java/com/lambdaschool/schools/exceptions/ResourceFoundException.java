package com.lambdaschool.schools.exceptions;

public class ResourceFoundException extends RuntimeException
{
    public ResourceFoundException(String message)
    {
        super("The following error was encountered in School app: " + message);
    }
}
