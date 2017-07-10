package com.zoujuequn.baseproject.model;

/**
 * <pre>
 *     author: MakeCodeFly
 *     email:15695947865@139.com
 * </pre>
 */
public class ChatModel {
    public String mMsg;
    public UserType mUserType;
    public ChatModel(String msg, UserType userType) {
        mMsg = msg;
        mUserType = userType;
    }

    public enum UserType {
        From, To
    }



}