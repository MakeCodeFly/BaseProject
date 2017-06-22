package com.zoujuequn.baseproject.model;

import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class CallResponse {

    private int status;
    private String statusReson;
    private String result;

    @JSONField(name = "status")
    public int getStatus() {
        return status;
    }

    @JSONField(name = "status")
    public void setStatus(int status) {
        this.status = status;
    }

    @JSONField(name = "msg")
    public String getStatusReson() {
        return statusReson;
    }

    @JSONField(name = "msg")
    public void setStatusReson(String statusReson) {
        this.statusReson = statusReson;
    }

    @JSONField(name = "data")
    public String getResult() {
        return result;
    }

    @JSONField(name = "data")
    public void setResult(String result) {
        this.result = result;
    }

    public <K> K getResult(Class<K> type) {
        return JSON.parseObject(this.result, type);
    }

    public <K> K getResult(String propertyName, Class<K> type) {
            JSONObject resultJson = JSON.parseObject(this.result);
            if (resultJson != null) {
                String tmp = resultJson.getString(propertyName);
                if (!TextUtils.isEmpty(tmp))
                    return JSON.parseObject(tmp, type);
            }
        return null;
    }

    public <K> List<K> getResultList(Class<K> type) {
        try {
            return JSON.parseArray(this.result, type);
        } catch (Exception e) {

        }
        return null;
    }

    public <K> List<K> getResultList(String propertyName, Class<K> type) {
            JSONObject resultJson = JSON.parseObject(this.result);
            if (resultJson != null) {
                String tmpList = resultJson.getString(propertyName);
                if (!TextUtils.isEmpty(tmpList))
                    return JSON.parseArray(tmpList, type);
            }
        return null;
    }


    @Override
    public String toString() {
        return "CallResponse [status=" + status + ", statusReson="
                + statusReson + ", result=" + result + "]";
    }

}
