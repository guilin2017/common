package com.common.exception;

public class ServiceExcption extends RuntimeException {
    private String[] paramCodes;
    
    public String[] getParamCodes() {
		return paramCodes;
	}
	public void setParamCodes(String[] paramCodes) {
		this.paramCodes = paramCodes;
	}
    public ServiceExcption() {
    }
	public ServiceExcption(String msg) {
        super(msg);
    }
	public ServiceExcption(String msg,String[] params) {
        super(msg);
        paramCodes = params;
    }
    public ServiceExcption(String msg, Throwable cause) {
        super(msg, cause);
    }
    public ServiceExcption(String msg, Throwable cause, String[] params) {
        super(msg, cause);
        paramCodes = params;
    }
    public ServiceExcption(Throwable cause) {
        super(cause);
    }
}