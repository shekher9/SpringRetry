package com.ri.exception;

public class RemoteServiceNotAvalableException extends RuntimeException {
	

	private static final long serialVersionUID = 1L;
	
	public RemoteServiceNotAvalableException( String msg) {
		super(msg);
	}
	
	public RemoteServiceNotAvalableException(String msg,Exception ex) {
		super(msg,ex);
	}

	


}
