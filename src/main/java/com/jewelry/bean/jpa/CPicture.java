package com.jewelry.bean.jpa;

import javax.persistence.*;

@Entity
@Table(name = "c_picture", schema = "jewelry", catalog = "")
public class CPicture {
    private long id;
    private long commodityId;
    private Integer positionType;
    private String picName;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "commodity_id")
    public long getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(long commodityId) {
        this.commodityId = commodityId;
    }

    @Basic
    @Column(name = "position_type")
    public Integer getPositionType() {
        return positionType;
    }

    public void setPositionType(Integer positionType) {
        this.positionType = positionType;
    }

    @Basic
    @Column(name = "pic_name")
    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CPicture cPicture = (CPicture) o;

        if (id != cPicture.id) return false;
        if (commodityId != cPicture.commodityId) return false;
        if (positionType != null ? !positionType.equals(cPicture.positionType) : cPicture.positionType != null)
            return false;
        if (picName != null ? !picName.equals(cPicture.picName) : cPicture.picName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (commodityId ^ (commodityId >>> 32));
        result = 31 * result + (positionType != null ? positionType.hashCode() : 0);
        result = 31 * result + (picName != null ? picName.hashCode() : 0);
        return result;
    }
}
