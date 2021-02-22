package com.gura.spring05.Exception;

public class NotAllowException extends RuntimeException {
	public NotAllowException(String msg) {
		super(msg);
	}
}
