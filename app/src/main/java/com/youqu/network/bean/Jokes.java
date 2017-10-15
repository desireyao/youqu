package com.youqu.network.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/10/14 0014.
 * 段子
 */

public class Jokes {
    private String msg;
    private String retCode;
    private Result result;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public static class Result{
        private int curPage;
        private int total;
        private List<Data> list;

        public int getCurPage() {
            return curPage;
        }

        public void setCurPage(int curPage) {
            this.curPage = curPage;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<Data> getList() {
            return list;
        }

        public void setList(List<Data> list) {
            this.list = list;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "curPage=" + curPage +
                    ", total=" + total +
                    ", list=" + list +
                    '}';
        }

        public static class Data{
           private String sourceUrl;
           private String subTitle;
           private String thumbnails;
           private String title;

            public String getSourceUrl() {
                return sourceUrl;
            }

            public void setSourceUrl(String sourceUrl) {
                this.sourceUrl = sourceUrl;
            }

            public String getSubTitle() {
                return subTitle;
            }

            public void setSubTitle(String subTitle) {
                this.subTitle = subTitle;
            }

            public String getThumbnails() {
                return thumbnails;
            }

            public void setThumbnails(String thumbnails) {
                this.thumbnails = thumbnails;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            @Override
            public String toString() {
                return "Data{" +
                        "sourceUrl='" + sourceUrl + '\'' +
                        ", subTitle='" + subTitle + '\'' +
                        ", thumbnails='" + thumbnails + '\'' +
                        ", title='" + title + '\'' +
                        '}';
            }
        }
    }

    @Override
    public String toString() {
        return "Jokes{" +
                "msg='" + msg + '\'' +
                ", retCode='" + retCode + '\'' +
                ", result=" + result +
                '}';
    }
}
