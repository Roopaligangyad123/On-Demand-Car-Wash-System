package com.cg.payload;

public class ErrorInfo {
	private String uri;
	private String message;

	public ErrorInfo(String uri, String message) {
		super();
		this.uri = uri;
		this.message = message;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
