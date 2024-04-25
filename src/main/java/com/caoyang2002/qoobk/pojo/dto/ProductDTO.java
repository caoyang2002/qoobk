package com.caoyang2002.qoobk.pojo.dto;

public class ProductDTO {
    private String title;
    private String url;
    private Double price;
    private Double oldPrice;
    private Integer saleCount;
    private Integer num;
    private Integer categoryId;

    @Override
    public String toString() {
        return "ProductDTO{" +
                "title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", price=" + price +
                ", oldPrice=" + oldPrice +
                ", saleCount=" + saleCount +
                ", num=" + num +
                ", categoryId=" + categoryId +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(Double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public Integer getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
