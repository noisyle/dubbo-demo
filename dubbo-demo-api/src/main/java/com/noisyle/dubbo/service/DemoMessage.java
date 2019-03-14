package com.noisyle.dubbo.service;

import java.io.Serializable;
import java.util.Date;

public class DemoMessage implements Serializable {
    private static final long serialVersionUID = 4496143975638310484L;
    private String msg;
	private Date timestamp;

    public DemoMessage(String msg, Date timestamp) {
        super();
        this.msg = msg;
        this.timestamp = timestamp;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
	
}
