package com.jewelry.bean.jpa.en;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "join_us", schema = "jewelry_en", catalog = "")
public class JoinUs {
    private long id;
    private String content;
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
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

        JoinUs joinUs = (JoinUs) o;

        if (id != joinUs.id) return false;
        if (content != null ? !content.equals(joinUs.content) : joinUs.content != null) return false;
        if (createTime != null ? !createTime.equals(joinUs.createTime) : joinUs.createTime != null) return false;
        if (status != null ? !status.equals(joinUs.status) : joinUs.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
