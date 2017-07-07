package com.zoujuequn.baseproject.model;


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