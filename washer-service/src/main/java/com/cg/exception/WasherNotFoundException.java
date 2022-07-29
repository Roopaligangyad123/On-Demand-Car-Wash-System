package com.cg.exception;

public class WasherNotFoundException extends RuntimeException
{

	    private static final long serialVersionUID = 1L;

	    public WasherNotFoundException(String message) {
	        super(message);
	    }
	}

