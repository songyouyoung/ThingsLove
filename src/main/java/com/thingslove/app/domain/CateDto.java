package com.thingslove.app.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class CateDto {
    private Integer cateNo;
    private Integer userNo;
    private String cateName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cateRegDate;
    private Integer cateCnt;

    public Integer getCateNo() {
        return cateNo;
    }

    public void setCateNo(Integer cateNo) {
        this.cateNo = cateNo;
    }

    public Integer getUserNo() {
        return userNo;
    }

    public void setUserNo(Integer userNo) {
        this.userNo = userNo;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public Date getCateRegDate() {
        return cateRegDate;
    }

    public void setCateRegDate(Date cateRegDate) {
        this.cateRegDate = cateRegDate;
    }

    public Integer getCateCnt() {
        return cateCnt;
    }

    public void setCateCnt(Integer cateCnt) {
        this.cateCnt = cateCnt;
    }

    @Override
    public String toString() {
        return "CateDto{" +
                "cateNo=" + cateNo +
                ", userNo=" + userNo +
                ", cateName='" + cateName + '\'' +
                ", cateRegDate=" + cateRegDate +
                ", cateCnt=" + cateCnt +
                '}';
    }
}
