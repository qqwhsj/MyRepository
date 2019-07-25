package com.woniuxy.entity;

import java.util.List;

public class PageBean {
    private List list;             //当前页清单
    private int totalPage;              //总页数
    private int pageSize;             //页大小
    private int pageIndex;          //当前页
    private int beginPage;        //开始页
    private int endPage;       //结束页
    private int totalElm;    //总元素数
    private int num=1;

    @Override
    public String toString() {
        return "PageBean{" +
                "list=" + list +
                ", totalPage=" + totalPage +
                ", pageSize=" + pageSize +
                ", pageIndex=" + pageIndex +
                ", beginPage=" + beginPage +
                ", endPage=" + endPage +
                ", totalElm=" + totalElm +
                '}';
    }

    public void setList(List list) {
        this.list = list;
    }

    public void setTotalPage() {
        if(totalElm%pageSize==0){
            totalPage=totalElm/pageSize;
        }else{
            totalPage=totalElm/pageSize+1;
        }
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public void setBeginAndEndPage() {
        if(pageIndex-num>0 && pageIndex+num<=totalPage){   //下标与上标都不越界
            beginPage=pageIndex-num;
            endPage=pageIndex+num;
        }else if(totalPage<(2*num+1)){     //总页数小于显示数
            beginPage=1;
            endPage=totalPage;
        }else if(pageIndex-num<=0){     //下标越界
            beginPage=1;
            endPage=beginPage+2*num;
        }else if(pageIndex+num>totalPage){  //上标越界
            endPage=totalPage;
            beginPage=endPage-2*num;
        }
    }

    public void setTotalElm(int totalElm) {
        this.totalElm = totalElm;
    }

    public List getList() {
        return list;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public int getBeginPage() {
        return beginPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public int getTotalElm() {
        return totalElm;
    }

    public PageBean(List<Msg> list, int totalPage, int pageSize, int pageIndex, int beginPage, int endPage, int totalElm) {
        this.list = list;
        this.totalPage = totalPage;
        this.pageSize = pageSize;
        this.pageIndex = pageIndex;
        this.beginPage = beginPage;
        this.endPage = endPage;
        this.totalElm = totalElm;
    }

    public PageBean() {
    }
}
