package com.jewelry.bean.jpa.cn;

import javax.persistence.*;

@Entity
@Table(name = "home_page", schema = "jewelry", catalog = "")
public class HomePage {
    private long id;
    private Integer cType;
    private String content;
    private Integer indexOrder;
    private Integer lineOrder;
    private Long goId;
    private Integer status;
    private Integer widthNum;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "c_type")
    public Integer getcType() {
        return cType;
    }

    public void setcType(Integer cType) {
        this.cType = cType;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "index_order")
    public Integer getIndexOrder() {
        return indexOrder;
    }

    public void setIndexOrder(Integer indexOrder) {
        this.indexOrder = indexOrder;
    }

    @Basic
    @Column(name = "line_order")
    public Integer getLineOrder() {
        return lineOrder;
    }

    public void setLineOrder(Integer lineOrder) {
        this.lineOrder = lineOrder;
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
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "width_num")
    public Integer getWidthNum() {
        return widthNum;
    }

    public void setWidthNum(Integer widthNum) {
        this.widthNum = widthNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HomePage homePage = (HomePage) o;

        if (id != homePage.id) return false;
        if (cType != null ? !cType.equals(homePage.cType) : homePage.cType != null) return false;
        if (content != null ? !content.equals(homePage.content) : homePage.content != null) return false;
        if (indexOrder != null ? !indexOrder.equals(homePage.indexOrder) : homePage.indexOrder != null) return false;
        if (lineOrder != null ? !lineOrder.equals(homePage.lineOrder) : homePage.lineOrder != null) return false;
        if (goId != null ? !goId.equals(homePage.goId) : homePage.goId != null) return false;
        if (status != null ? !status.equals(homePage.status) : homePage.status != null) return false;
        if (widthNum != null ? !widthNum.equals(homePage.widthNum) : homePage.widthNum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (cType != null ? cType.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (indexOrder != null ? indexOrder.hashCode() : 0);
        result = 31 * result + (lineOrder != null ? lineOrder.hashCode() : 0);
        result = 31 * result + (goId != null ? goId.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (widthNum != null ? widthNum.hashCode() : 0);
        return result;
    }
}
