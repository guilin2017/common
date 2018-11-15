package com.common.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class TimelineInfo implements Serializable {

    @ApiModelProperty("是否有下一页")
    private boolean hasNext;

    @ApiModelProperty("时间戳")
    private long timestamp;

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}


