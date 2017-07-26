package com.noisyle.dubbodemo.service;

public class DemoException extends RuntimeException {
	
	private static final long serialVersionUID = -1682359541586774967L;
	
	public DemoException() {
		super();
	}

	public DemoException(String message) {
		super(message);
	}

	public DemoException(Throwable cause) {
		super(cause);
	}
	
	public DemoException(String message, Throwable cause) {
		super(message, cause);
	}
}
