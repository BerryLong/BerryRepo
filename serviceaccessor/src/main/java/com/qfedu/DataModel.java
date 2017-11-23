package com.qfedu;

import java.util.List;

public class DataModel {
    private int code;
    private String msg;
    private List<NewsModel> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewsModel> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewsModel> newslist) {
        this.newslist = newslist;
    }
}
