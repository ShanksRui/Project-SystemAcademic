package com.dev.System_Academic.Resources.Exception;

import java.time.Instant;

public class StandardError {

	private Instant moment;
	private Integer status;
	private String error;
	private String erroMsg;
	private String path;
	
	
	public StandardError() {

	}

	public StandardError(Instant moment, Integer status, String error, String erroMsg, String path) {
		this.moment = moment;
		this.status = status;
		this.error = error;
		this.erroMsg = erroMsg;
		this.path = path;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getErroMsg() {
		return erroMsg;
	}

	public void setErroMsg(String erroMsg) {
		this.erroMsg = erroMsg;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
}
