package com.jewelry.bean.jpa;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Commodity {
    private long id;
    private String title;
    private String enTitle;
    private String listTitle;
    private String enListTitle;
    private int price;
    private String body;
    private String enBody;
    private long typeId;
    private Long meterialId;
    private long partId;
    private Timestamp createTime;
    private Timestamp modifyTime;
    private Long clicks;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "en_title")
    public String getEnTitle() {
        return enTitle;
    }

    public void setEnTitle(String enTitle) {
        this.enTitle = enTitle;
    }

    @Basic
    @Column(name = "list_title")
    public String getListTitle() {
        return listTitle;
    }

    public void setListTitle(String listTitle) {
        this.listTitle = listTitle;
    }

    @Basic
    @Column(name = "en_list_title")
    public String getEnListTitle() {
        return enListTitle;
    }

    public void setEnListTitle(String enListTitle) {
        this.enListTitle = enListTitle;
    }

    @Basic
    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Basic
    @Column(name = "body")
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Basic
    @Column(name = "en_body")
    public String getEnBody() {
        return enBody;
    }

    public void setEnBody(String enBody) {
        this.enBody = enBody;
    }

    @Basic
    @Column(name = "type_id")
    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    @Basic
    @Column(name = "meterial_id")
    public Long getMeterialId() {
        return meterialId;
    }

    public void setMeterialId(Long meterialId) {
        this.meterialId = meterialId;
    }

    @Basic
    @Column(name = "part_id")
    public long getPartId() {
        return partId;
    }

    public void setPartId(long partId) {
        this.partId = partId;
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
    @Column(name = "modify_time")
    public Timestamp getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Timestamp modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Basic
    @Column(name = "clicks")
    public Long getClicks() {
        return clicks;
    }

    public void setClicks(Long clicks) {
        this.clicks = clicks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Commodity commodity = (Commodity) o;

        if (id != commodity.id) return false;
        if (price != commodity.price) return false;
        if (typeId != commodity.typeId) return false;
        if (partId != commodity.partId) return false;
        if (title != null ? !title.equals(commodity.title) : commodity.title != null) return false;
        if (enTitle != null ? !enTitle.equals(commodity.enTitle) : commodity.enTitle != null) return false;
        if (listTitle != null ? !listTitle.equals(commodity.listTitle) : commodity.listTitle != null) return false;
        if (enListTitle != null ? !enListTitle.equals(commodity.enListTitle) : commodity.enListTitle != null)
            return false;
        if (body != null ? !body.equals(commodity.body) : commodity.body != null) return false;
        if (enBody != null ? !enBody.equals(commodity.enBody) : commodity.enBody != null) return false;
        if (meterialId != null ? !meterialId.equals(commodity.meterialId) : commodity.meterialId != null) return false;
        if (createTime != null ? !createTime.equals(commodity.createTime) : commodity.createTime != null) return false;
        if (modifyTime != null ? !modifyTime.equals(commodity.modifyTime) : commodity.modifyTime != null) return false;
        if (clicks != null ? !clicks.equals(commodity.clicks) : commodity.clicks != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (enTitle != null ? enTitle.hashCode() : 0);
        result = 31 * result + (listTitle != null ? listTitle.hashCode() : 0);
        result = 31 * result + (enListTitle != null ? enListTitle.hashCode() : 0);
        result = 31 * result + price;
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (enBody != null ? enBody.hashCode() : 0);
        result = 31 * result + (int) (typeId ^ (typeId >>> 32));
        result = 31 * result + (meterialId != null ? meterialId.hashCode() : 0);
        result = 31 * result + (int) (partId ^ (partId >>> 32));
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (modifyTime != null ? modifyTime.hashCode() : 0);
        result = 31 * result + (clicks != null ? clicks.hashCode() : 0);
        return result;
    }
}
