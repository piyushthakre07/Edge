package com.beans;

import java.io.Serializable;

public class CommonResponseBean implements Serializable {
	private static final long serialVersionUID = 5874394960120950486L;
	private String message;
	private String statusCode;
	private String errorCode;

	public CommonResponseBean() {

	}

	public CommonResponseBean(String message, String statusCode, String errorCode) {
		this.message = message;
		this.statusCode = statusCode;
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}
