package com.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ASFresponse {
    public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public Result getRs() {
		return rs;
	}
	public void setRs(Result rs) {
		this.rs = rs;
	}
	public boolean isSuccess() {
		return Success;
	}
	public void setSuccess(boolean success) {
		Success = success;
	}
	private String Message;
    private Result rs;
    private boolean Success;
}
