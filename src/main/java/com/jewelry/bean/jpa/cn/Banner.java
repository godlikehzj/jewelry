package com.jewelry.bean.jpa.cn;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Banner {
    private long id;
    private Long goId;
    private String imgUrl;
    private Integer status;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "go_id")
    public Long getGoId() {
        return goId;
    }

    public void setGoId(Long goId) {
        this.goId = goId;
    }

    @Basic
    @Column(name = "img_url")
    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Banner banner = (Banner) o;

        if (id != banner.id) return false;
        if (goId != null ? !goId.equals(banner.goId) : banner.goId != null) return false;
        if (imgUrl != null ? !imgUrl.equals(banner.imgUrl) : banner.imgUrl != null) return false;
        if (status != null ? !status.equals(banner.status) : banner.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (goId != null ? goId.hashCode() : 0);
        result = 31 * result + (imgUrl != null ? imgUrl.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
