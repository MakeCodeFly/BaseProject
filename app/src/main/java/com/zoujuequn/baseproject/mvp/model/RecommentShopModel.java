package com.zoujuequn.baseproject.mvp.model;

import com.alibaba.fastjson.annotation.JSONType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tangzelai on 2017/7/14.
 * com.zoujuequn.baseproject.mvp.model
 */
public class RecommentShopModel {

    private boolean is_last;

    private List<list> list = new ArrayList<list>();

    public boolean is_last() {
        return is_last;
    }

    public void setIs_last(boolean is_last) {
        this.is_last = is_last;
    }

    public List<RecommentShopModel.list> getList() {
        return list;
    }

    public void setList(List<RecommentShopModel.list> list) {
        this.list = list;
    }

    @JSONType(ignores = {"list"})
    public static class list {
        private int os_id;
        private String os_logo;
        private String os_name;
        private String os_jianjie;
        private String os_latitude;
        private String os_longitude;
        private String os_distance;


        public int getOs_id() {
            return os_id;
        }

        public void setOs_id(int os_id) {
            this.os_id = os_id;
        }

        public String getOs_logo() {
            return os_logo;
        }

        public void setOs_logo(String os_logo) {
            this.os_logo = os_logo;
        }

        public String getOs_name() {
            return os_name;
        }

        public void setOs_name(String os_name) {
            this.os_name = os_name;
        }

        public String getOs_jianjie() {
            return os_jianjie;
        }

        public void setOs_jianjie(String os_jianjie) {
            this.os_jianjie = os_jianjie;
        }

        public String getOs_latitude() {
            return os_latitude;
        }

        public void setOs_latitude(String os_latitude) {
            this.os_latitude = os_latitude;
        }

        public String getOs_longitude() {
            return os_longitude;
        }

        public void setOs_longitude(String os_longitude) {
            this.os_longitude = os_longitude;
        }

        public String getOs_distance() {
            return os_distance;
        }

        public void setOs_distance(String os_distance) {
            this.os_distance = os_distance;
        }
    }



}
