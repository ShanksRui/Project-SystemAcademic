package com.dev.System_Academic.Entities.Enum;

public enum StatusSubject {
	
	INPROGRESS(1),
	COMPLETED(2),
	FAILED(3);
	
	private final int code;
	
	private StatusSubject(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static StatusSubject StatusCodeValue(int code) {
		for(StatusSubject value: StatusSubject.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		  throw new IllegalArgumentException("Invalid code!"+ code);
	}
	
}
