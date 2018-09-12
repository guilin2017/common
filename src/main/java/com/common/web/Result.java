package com.common.web;

import com.common.model.BaseObject;

public class Result<T>{


	/**
     * 是否成功
     */
    private boolean success;

    /**
     * 结果信息编号，对应字典
     */
    private String resultCode = "200";

    /**
     * 返回的消息
     */
    private String resultMsg= "调用成功！";

    /**
     * 返回值，类型为T
     */
    private T date;
    
    public Result() {
    }

    public Result(boolean success) {
        this.success = success;
    }

    /**
     * 是否成功
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * 设置是否成功
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * 结果信息编号，对应字典
     */
    public String getResultCode() {
        return resultCode;
    }

    /**
     * 结果信息编号，对应字典
     */
    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    /**
     * 返回的消息
     */
    public String getResultMsg() {
        return resultMsg;
    }

    /**
     * 返回的消息
     */
    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public T getDate() {
		return date;
	}

	public void setDate(T date) {
		this.date = date;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Result that = (Result) o;

        if (success != that.success) return false;
        if (resultCode != null ? !resultCode.equals(that.resultCode) : that.resultCode != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (success ? 1 : 0);
        result = 31 * result + (resultCode != null ? resultCode.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Result{" +
                "resultCode='" + resultCode + '\'' +
                ", success=" + success +
                ", date=" + date +
                '}';
    }
}
