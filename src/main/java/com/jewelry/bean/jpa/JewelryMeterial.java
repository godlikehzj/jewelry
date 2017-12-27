package com.jewelry.bean.jpa;

import javax.persistence.*;

@Entity
@Table(name = "jewelry_meterial", schema = "jewelry", catalog = "")
public class JewelryMeterial {
    private long id;
    private String name;
    private String enName;
    private Long typeId;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "en_name")
    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    @Basic
    @Column(name = "type_id")
    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JewelryMeterial that = (JewelryMeterial) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (enName != null ? !enName.equals(that.enName) : that.enName != null) return false;
        if (typeId != null ? !typeId.equals(that.typeId) : that.typeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (enName != null ? enName.hashCode() : 0);
        result = 31 * result + (typeId != null ? typeId.hashCode() : 0);
        return result;
    }
}
