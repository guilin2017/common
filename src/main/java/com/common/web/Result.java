package com.common.web;

import com.common.model.TimelineInfo;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@ApiModel(value = "Result", description = "通用返回对象")
public class Result<T> implements Serializable{
	
	private static final long serialVersionUID = -6613595801693213718L;
	
    
    @ApiModelProperty(value = "返回状态，true表示正常，false表示不成功")
    private boolean success = true;
    /**
     * the returning code of transaction or operation
     */
    @ApiModelProperty(value = "失败错误码")
    private String resultCode;
    /**
     * the returning Message of transaction or operation
     */
    @ApiModelProperty(value = "返回状态说明，success为false情况下表示失败原因")
    private String message;
    /**
     * single model
     */
    @SuppressWarnings("all")
    @ApiModelProperty(value = "返回的单个对象")
    private T model;
    /**
     * multi models
     */
    @SuppressWarnings("all")
    @ApiModelProperty(value = "返回的集合对象")
    private List<T> models;


    @ApiModelProperty(value = "分页详细信息")
    private PageInfo<T> pageInfo;

    @ApiModelProperty(value = "timeline参数")
    private TimelineInfo timelineInfo;
    /**
     * extra info
     */
    @SuppressWarnings("all")
    @ApiModelProperty(value = "额外信息", hidden = true)
    private Object extra;

    /**
     * is valid
     * add by liuqingkai
     */
    @ApiModelProperty(value = "业务校验是否成功", hidden = true)
    private boolean isValid = true;

    /**
     * validate Messages
     * add by liuqingkai
     */
    @ApiModelProperty(value = "业务校验错误信息", hidden = true)
    private List<String> validationMessages;


    public List<String> getValidationMessages() {
        return validationMessages;
    }


    public void setValidationMessages(List<String> validationMessages) {
        this.validationMessages = validationMessages;
    }


    public void setValidationErrorMessages(BindingResult errors) {
        List<String> errorMessages = new ArrayList<String>();
        Iterator<FieldError> iter = errors.getFieldErrors().iterator();
        while (iter.hasNext()) {
            errorMessages.add(iter.next().getDefaultMessage());
        }
        this.setValidationMessages(errorMessages);
    }


    public boolean isValid() {
        return isValid;
    }


    public void setValid(boolean isValid) {
        this.isValid = isValid;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    public List<T> getModels() {
        if(null != this.models){
            return models;
        }else{
            return new ArrayList<T>();
        }
    }

    public void setModels(List<T> models) {
        this.models = models;
    }

    public Object getExtra() {
        return extra;
    }

    public void setExtra(Object extra) {
        this.extra = extra;
    }


    public PageInfo<T> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<T> pageInfo) {
        this.pageInfo = pageInfo;
    }

    public TimelineInfo getTimelineInfo() {
        return timelineInfo;
    }

    public void setTimelineInfo(TimelineInfo timelineInfo) {
        this.timelineInfo = timelineInfo;
    }
}