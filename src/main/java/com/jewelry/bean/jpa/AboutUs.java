package com.jewelry.bean.jpa;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "about_us", schema = "jewelry", catalog = "")
public class AboutUs {
    private long id;
    private String tabName;
    private String enTabName;
    private String content;
    private String enContent;
    private Timestamp createTime;
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
    @Column(name = "tab_name")
    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }

    @Basic
    @Column(name = "en_tab_name")
    public String getEnTabName() {
        return enTabName;
    }

    public void setEnTabName(String enTabName) {
        this.enTabName = enTabName;
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
    @Column(name = "en_content")
    public String getEnContent() {
        return enContent;
    }

    public void setEnContent(String enContent) {
        this.enContent = enContent;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
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

        AboutUs aboutUs = (AboutUs) o;

        if (id != aboutUs.id) return false;
        if (tabName != null ? !tabName.equals(aboutUs.tabName) : aboutUs.tabName != null) return false;
        if (enTabName != null ? !enTabName.equals(aboutUs.enTabName) : aboutUs.enTabName != null) return false;
        if (content != null ? !content.equals(aboutUs.content) : aboutUs.content != null) return false;
        if (enContent != null ? !enContent.equals(aboutUs.enContent) : aboutUs.enContent != null) return false;
        if (createTime != null ? !createTime.equals(aboutUs.createTime) : aboutUs.createTime != null) return false;
        if (status != null ? !status.equals(aboutUs.status) : aboutUs.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (tabName != null ? tabName.hashCode() : 0);
        result = 31 * result + (enTabName != null ? enTabName.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (enContent != null ? enContent.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
