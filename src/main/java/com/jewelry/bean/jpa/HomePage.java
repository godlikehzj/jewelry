package com.jewelry.bean.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class HomePage {
    @Id
    @GeneratedValue
    private Long id;
    private Integer c_type;
    private String content;
    private Integer index_order;
    private Integer line_order;
    private Long commodity_id;
    private Integer status;

    public HomePage() {
    }

    public HomePage(Integer c_type, String content, Integer index_order, Integer line_order, Long commodity_id, Integer status) {
        this.c_type = c_type;
        this.content = content;
        this.index_order = index_order;
        this.line_order = line_order;
        this.commodity_id = commodity_id;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getC_type() {
        return c_type;
    }

    public void setC_type(Integer c_type) {
        this.c_type = c_type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getIndex_order() {
        return index_order;
    }

    public void setIndex_order(Integer index_order) {
        this.index_order = index_order;
    }

    public Integer getLine_order() {
        return line_order;
    }

    public void setLine_order(Integer line_order) {
        this.line_order = line_order;
    }

    public Integer getStatus() {
        return status;
    }

    public Long getCommodity_id() {
        return commodity_id;
    }

    public void setCommodity_id(Long commodity_id) {
        this.commodity_id = commodity_id;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
