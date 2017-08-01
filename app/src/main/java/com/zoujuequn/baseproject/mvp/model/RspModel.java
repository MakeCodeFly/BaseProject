package com.zoujuequn.baseproject.mvp.model;

import java.util.Date;

/**
 * @author qiujuer Email:qiujuer@live.cn
 * @version 1.0.0
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class RspModel<T> {
    public static final int SUCCEED = 1;

    public static final int ERROR_UNKNOWN = 0;

    public static final int ERROR_NOT_FOUND_USER = 4041;
    public static final int ERROR_NOT_FOUND_GROUP = 4042;
    public static final int ERROR_NOT_FOUND_GROUP_MEMBER = 4043;

    public static final int ERROR_CREATE_USER = 3001;
    public static final int ERROR_CREATE_GROUP = 3002;
    public static final int ERROR_CREATE_MESSAGE = 3003;

    public static final int ERROR_PARAMETERS = 4001;
    public static final int ERROR_PARAMETERS_EXIST_ACCOUNT = 4002;
    public static final int ERROR_PARAMETERS_EXIST_NAME = 4003;

    public static final int ERROR_SERVICE = 5001;

    public static final int ERROR_ACCOUNT_TOKEN = 2001;
    public static final int ERROR_ACCOUNT_LOGIN = 2002;
    public static final int ERROR_ACCOUNT_REGISTER = 2003;

    public static final int ERROR_ACCOUNT_NO_PERMISSION = 2010;
    private int status;
    private int code;
    private String msg;
    private Date time;
    private T data;


    public boolean success() {
        return status == SUCCEED;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RspModel{" +
                "status=" + status +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                ", time=" + time +
                ", data=" + data +
                '}';
    }
}