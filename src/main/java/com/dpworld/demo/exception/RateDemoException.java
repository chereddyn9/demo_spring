package com.dpworld.demo.exception;

public class RateDemoException extends Exception{

	private String errorCode;
	private String errorMsg;
	
	public RateDemoException(String errorCode) {
		super();
		this.errorCode = errorCode;
	}
	public RateDemoException(String errorCode, String errorMsg) {
		super();
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}
	
	public RateDemoException() {
		super();
	}
	
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	@Override
	public String toString() {
		return "RateDemoException [errorCode=" + errorCode + ", errorMsg=" + errorMsg + "]";
	}
	
	
}
