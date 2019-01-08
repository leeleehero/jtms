package com.jk.jtms.comm;


public class PageUtil<T>{
    private Integer pageSize=10;
    private Integer pageNo;
    private Integer totalPage;
    private Integer count;
    private T data;

    public PageUtil(Integer pageSize, Integer pageNo, Integer count, T data) {
        this.pageSize = pageSize;
        this.pageNo = pageNo;
        this.totalPage = (int) Math.ceil((double) count / (double) pageSize);
        this.count = count;
        this.data = data;
    }

    public PageUtil() {
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
