package com.zoujuequn.baseproject.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DataEngine {

    public static List<ChatModel> loadChatModelDatas() {
        List<ChatModel> datas = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            if (i % 3 == 0) {
                datas.add(new ChatModel("消息" + i, ChatModel.UserType.To));
            } else {
                datas.add(new ChatModel("消息" + i, ChatModel.UserType.From));
            }
        }
        return datas;


    }

}