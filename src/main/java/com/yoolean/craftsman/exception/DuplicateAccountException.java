package com.yoolean.craftsman.exception;

/**
 * Created by harry on 16-8-5.
 */
public class DuplicateAccountException
    extends RuntimeException
{
    public DuplicateAccountException( String message )
    {
        super( message );
    }
}
