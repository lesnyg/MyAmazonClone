package com.lesnyg.myamazonclone.models;

import java.util.List;
import java.util.Map;

public class Product {
    private List<String> photoUrls;
    private String title;
    private int price;
    private Map<Integer,Integer> stars;
    private List<String> options;
    private String detail;
    private String maker;

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Map<Integer, Integer> getStars() {
        return stars;
    }

    public void setStars(Map<Integer, Integer> stars) {
        this.stars = stars;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Product{");
        sb.append("photoUrls=").append(photoUrls);
        sb.append(", title='").append(title).append('\'');
        sb.append(", price=").append(price);
        sb.append(", stars=").append(stars);
        sb.append(", options=").append(options);
        sb.append(", detail='").append(detail).append('\'');
        sb.append(", maker='").append(maker).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
