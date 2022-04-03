package com.main.api.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
public class Commodity {
    private Long commId;

    private String commName;

    private Integer commStock;

    private BigDecimal commPrice;

    private String commDetail;

    private String commType;

    private Long commUserid;

    private Date gmtCreate;

    private Date gmtModified;

    public Long getCommId() {
        return commId;
    }

    public void setCommId(Long commId) {
        this.commId = commId;
    }

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName == null ? null : commName.trim();
    }

    public Integer getCommStock() {
        return commStock;
    }

    public void setCommStock(Integer commStock) {
        this.commStock = commStock;
    }

    public BigDecimal getCommPrice() {
        return commPrice;
    }

    public void setCommPrice(BigDecimal commPrice) {
        this.commPrice = commPrice;
    }

    public String getCommDetail() {
        return commDetail;
    }

    public void setCommDetail(String commDetail) {
        this.commDetail = commDetail == null ? null : commDetail.trim();
    }

    public String getCommType() {
        return commType;
    }

    public void setCommType(String commType) {
        this.commType = commType == null ? null : commType.trim();
    }

    public Long getCommUserid() {
        return commUserid;
    }

    public void setCommUserid(Long commUserid) {
        this.commUserid = commUserid;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}