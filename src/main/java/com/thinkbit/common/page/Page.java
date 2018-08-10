//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.thinkbit.common.page;

public class Page {
    public static final String SORT_TYPE_ASC = "asc";
    public static final String SORT_TYPE_DES = "desc";
    private long totals;
    private int startIndex;
    private int pageSize;
    private String sortItem;
    private String sortType;

    public Page(int startIndex, int pageSize) {
        this(startIndex, pageSize, "", "asc");
    }

    public Page(int startIndex, int pageSize, String sortItem) {
        this(startIndex, pageSize, sortItem, "asc");
    }

    public Page(int startIndex, int pageSize, String sortItem, String sortType) {
        this.pageSize = 50;
        this.sortType = "asc";
        this.startIndex = startIndex;
        this.pageSize = pageSize;
        this.sortItem = sortItem;
        this.sortType = sortType;
    }

    public long getTotals() {
        return this.totals;
    }

    public int getStartIndex() {
        return this.startIndex;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public String getSortItem() {
        return this.sortItem;
    }

    public String getSortType() {
        return this.sortType;
    }

    public void setTotals(long totals) {
        this.totals = totals;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setSortItem(String sortItem) {
        this.sortItem = sortItem;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Page)) {
            return false;
        } else {
            Page other = (Page) o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getTotals() != other.getTotals()) {
                return false;
            } else if (this.getStartIndex() != other.getStartIndex()) {
                return false;
            } else if (this.getPageSize() != other.getPageSize()) {
                return false;
            } else {
                Object this$sortItem = this.getSortItem();
                Object other$sortItem = other.getSortItem();
                if (this$sortItem == null) {
                    if (other$sortItem != null) {
                        return false;
                    }
                } else if (!this$sortItem.equals(other$sortItem)) {
                    return false;
                }

                Object this$sortType = this.getSortType();
                Object other$sortType = other.getSortType();
                if (this$sortType == null) {
                    if (other$sortType != null) {
                        return false;
                    }
                } else if (!this$sortType.equals(other$sortType)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof Page;
    }

    public int hashCode() {
        int result = 1;
        long $totals = this.getTotals();
        result = result * 59 + (int) ($totals >>> 32 ^ $totals);
        result = result * 59 + this.getStartIndex();
        result = result * 59 + this.getPageSize();
        Object $sortItem = this.getSortItem();
        result = result * 59 + ($sortItem == null ? 43 : $sortItem.hashCode());
        Object $sortType = this.getSortType();
        result = result * 59 + ($sortType == null ? 43 : $sortType.hashCode());
        return result;
    }

    public String toString() {
        return "Page(totals=" + this.getTotals() + ", startIndex=" + this.getStartIndex() + ", pageSize=" + this.getPageSize() + ", sortItem=" + this.getSortItem() + ", sortType=" + this.getSortType() + ")";
    }

    public Page() {
        this.pageSize = 50;
        this.sortType = "asc";
    }
}
