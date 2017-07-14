package com.zoujuequn.baseproject.mvp.model;


import com.alibaba.fastjson.annotation.JSONType;

import java.util.ArrayList;
import java.util.List;

public class IndexBannerModel {

    private List<list> list = new ArrayList<list>();

    public List<IndexBannerModel.list> getList() {
        return list;
    }

    public void setList(List<IndexBannerModel.list> list) {
        this.list = list;
    }

    @JSONType(ignores = {"list"})
    public static class list {
        private String banner_id;
        private String banner_type;
        private String banner_o_id;
        private String banner_pic;
        private String banner_orders;
        private String banner_addtime;

        public String getBanner_id() {
            return banner_id;
        }

        public void setBanner_id(String banner_id) {
            this.banner_id = banner_id;
        }

        public String getBanner_type() {
            return banner_type;
        }

        public void setBanner_type(String banner_type) {
            this.banner_type = banner_type;
        }

        public String getBanner_o_id() {
            return banner_o_id;
        }

        public void setBanner_o_id(String banner_o_id) {
            this.banner_o_id = banner_o_id;
        }

        public String getBanner_pic() {
            return banner_pic;
        }

        public void setBanner_pic(String banner_pic) {
            this.banner_pic = banner_pic;
        }

        public String getBanner_orders() {
            return banner_orders;
        }

        public void setBanner_orders(String banner_orders) {
            this.banner_orders = banner_orders;
        }

        public String getBanner_addtime() {
            return banner_addtime;
        }

        public void setBanner_addtime(String banner_addtime) {
            this.banner_addtime = banner_addtime;
        }
    }


}
