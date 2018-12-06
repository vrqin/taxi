package com.spring.jersy.hibernate.publics.util;

import java.util.List;

/**
 * Created by Administrator on 2016/1/9.
 */
public class PageList {

    private int pagenow; // 当前页数
    @SuppressWarnings("unused")
    private int totalPage; // 总页数
    private int totalRecord = -1; // 总记录数
    private int pageSize; // 每页条数

    @SuppressWarnings("unused")
    private boolean hasFirst; // 是否有第一条
    @SuppressWarnings("unused")
    private boolean hasPrevious; // 是否有上一条;
    @SuppressWarnings("unused")
    private boolean hasNext; // 是否有下一条;
    @SuppressWarnings("unused")
    private boolean hasLast; // 是否有最后一条;

    private List list; // 查询的结果

    public PageList() {
    }

    public PageList(int pagenow, int pageSize) {
        this.pagenow = pagenow;
        this.pageSize = pageSize;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public boolean isHasFirst() {
        if (pagenow <= 1) {
            return false;
        } else {
            return true;
        }
    }

    public void setHasFirst(boolean hasFirst) {
        this.hasFirst = hasFirst;
    }

    public boolean isHasLast() {
        if (pagenow == this.getTotalPage()) {
            return false;
        } else {
            return true;
        }
    }

    public void setHasLast(boolean hasLast) {
        this.hasLast = hasLast;
    }

    public boolean isHasNext() {
        if (isHasLast()) {
            return true;
        } else {
            return false;
        }
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public boolean isHasPrevious() {
        if (isHasFirst()) {
            return true;
        } else {
            return false;
        }
    }

    public void setHasPrevious(boolean hasPrevious) {
        this.hasPrevious = hasPrevious;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        int total = totalRecord / pageSize;
        if (totalRecord % pageSize == 0) {
            return total;
        } else {
            return total + 1;
        }
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getPagenow() {
        return pagenow;
    }

    public void setPagenow(int pagenow) {
        this.pagenow = pagenow;
    }
}
