package com.jewelry.bean.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Banner {
    @Id
    @GeneratedValue
    private Long id;
    private Long commodity_id;
    private String img_url;
    private int status;

    public Banner() {
    }

    public Banner(Long commodity_id, String img_url, int status) {
        this.commodity_id = commodity_id;
        this.img_url = img_url;
        this.status = status;
    }

    public Banner(Long commodity_id, String img_url) {
        this.commodity_id = commodity_id;
        this.img_url = img_url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCommodity_id() {
        return commodity_id;
    }

    public void setCommodity_id(Long commodity_id) {
        this.commodity_id = commodity_id;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
