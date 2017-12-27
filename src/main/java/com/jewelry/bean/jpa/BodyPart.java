package com.jewelry.bean.jpa;

import javax.persistence.*;

@Entity
@Table(name = "body_part", schema = "jewelry", catalog = "")
public class BodyPart {
    private long id;
    private String name;
    private String enName;
    private String description;
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
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

        BodyPart bodyPart = (BodyPart) o;

        if (id != bodyPart.id) return false;
        if (name != null ? !name.equals(bodyPart.name) : bodyPart.name != null) return false;
        if (enName != null ? !enName.equals(bodyPart.enName) : bodyPart.enName != null) return false;
        if (description != null ? !description.equals(bodyPart.description) : bodyPart.description != null)
            return false;
        if (typeId != null ? !typeId.equals(bodyPart.typeId) : bodyPart.typeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (enName != null ? enName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (typeId != null ? typeId.hashCode() : 0);
        return result;
    }
}
