package com.thingslove.app.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ItemDto {
    private Integer itemNo;
    private Integer userNo;
    private Integer cateNo;
    private String itemName;
    private String itemNickName;
    private String itemWhere;
    private Integer itemPrice;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date itemBuyDate;
    private String itemDesc;
    private String itemImg;
    private String itemImgRec;
    private String itemImgGuar;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date itemRegDate;

    public Integer getItemNo() {
        return itemNo;
    }

    public void setItemNo(Integer itemNo) {
        this.itemNo = itemNo;
    }

    public Integer getUserNo() {
        return userNo;
    }

    public void setUserNo(Integer userNo) {
        this.userNo = userNo;
    }

    public Integer getCateNo() {
        return cateNo;
    }

    public void setCateNo(Integer cateNo) {
        this.cateNo = cateNo;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemNickName() {
        return itemNickName;
    }

    public void setItemNickName(String itemNickName) {
        this.itemNickName = itemNickName;
    }

    public String getItemWhere() {
        return itemWhere;
    }

    public void setItemWhere(String itemWhere) {
        this.itemWhere = itemWhere;
    }

    public Integer getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Integer itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Date getItemBuyDate() {
        return itemBuyDate;
    }

    public void setItemBuyDate(Date itemBuyDate) {
        this.itemBuyDate = itemBuyDate;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public String getItemImg() {
        return itemImg;
    }

    public void setItemImg(String itemImg) {
        this.itemImg = itemImg;
    }

    public String getItemImgRec() {
        return itemImgRec;
    }

    public void setItemImgRec(String itemImgRec) {
        this.itemImgRec = itemImgRec;
    }

    public String getItemImgGuar() {
        return itemImgGuar;
    }

    public void setItemImgGuar(String itemImgGuar) {
        this.itemImgGuar = itemImgGuar;
    }

    public Date getItemRegDate() {
        return itemRegDate;
    }

    public void setItemRegDate(Date itemRegDate) {
        this.itemRegDate = itemRegDate;
    }

    @Override
    public String toString() {
        return "ItemDto{" +
                "itemNo=" + itemNo +
                ", userNo=" + userNo +
                ", cateNo=" + cateNo +
                ", itemName='" + itemName + '\'' +
                ", itemNickName='" + itemNickName + '\'' +
                ", itemWhere='" + itemWhere + '\'' +
                ", itemPrice=" + itemPrice +
                ", itemBuyDate=" + itemBuyDate +
                ", itemDesc='" + itemDesc + '\'' +
                ", itemImg='" + itemImg + '\'' +
                ", itemImgRec='" + itemImgRec + '\'' +
                ", itemImgGuar='" + itemImgGuar + '\'' +
                ", itemRegDate=" + itemRegDate +
                '}';
    }
}
