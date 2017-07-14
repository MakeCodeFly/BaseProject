package com.zoujuequn.baseproject.mvp.model;

import com.alibaba.fastjson.annotation.JSONType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tangzelai on 2017/7/14.
 * com.zoujuequn.baseproject.mvp.model
 */
public class GetIndexRecommentListModel {

    private boolean is_last;

    private List<list> list = new ArrayList<list>();

    public boolean is_last() {
        return is_last;
    }

    public void setIs_last(boolean is_last) {
        this.is_last = is_last;
    }

    public List<GetIndexRecommentListModel.list> getList() {
        return list;
    }

    public void setList(List<GetIndexRecommentListModel.list> list) {
        this.list = list;
    }

    @JSONType(ignores = {"list"})
    public static class list {
        private int osg_id;
        private String osg_name;
        private String osg_logo;
        private String osg_price;

        public int getOsg_id() {
            return osg_id;
        }

        public void setOsg_id(int osg_id) {
            this.osg_id = osg_id;
        }

        public String getOsg_name() {
            return osg_name;
        }

        public void setOsg_name(String osg_name) {
            this.osg_name = osg_name;
        }

        public String getOsg_logo() {
            return osg_logo;
        }

        public void setOsg_logo(String osg_logo) {
            this.osg_logo = osg_logo;
        }

        public String getOsg_price() {
            return osg_price;
        }

        public void setOsg_price(String osg_price) {
            this.osg_price = osg_price;
        }
    }

}
