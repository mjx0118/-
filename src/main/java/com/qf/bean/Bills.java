package com.qf.bean;

import java.util.Date;

public class Bills {
    private Integer id;

    private String title;

    private Date billtime;

    private Integer typeid;

    private Double price;

    private String details;
    private Billtype billtype;

    public Billtype getBilltype() {
        return billtype;
    }

    public void setBilltype(Billtype billtype) {
        this.billtype = billtype;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getBilltime() {
        return billtime;
    }

    public void setBilltime(Date billtime) {
        this.billtime = billtime;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details == null ? null : details.trim();
    }
}