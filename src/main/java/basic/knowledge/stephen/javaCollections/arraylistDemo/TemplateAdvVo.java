package basic.knowledge.stephen.javaCollections.arraylistDemo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TemplateAdvVo {
    private String isSingle;

    private Date created;

    private Date updated;
    private Integer lyyEquipmentTypeId;

    public TemplateAdvVo(String isSingle, Date created, Date updated, Integer lyyEquipmentTypeId) {
        this.isSingle = isSingle;
        this.created = created;
        this.updated = updated;
        this.lyyEquipmentTypeId = lyyEquipmentTypeId;
    }


    public String getIsSingle() {
        return isSingle;
    }

    public void setIsSingle(String isSingle) {
        this.isSingle = isSingle;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Integer getLyyEquipmentTypeId() {
        return lyyEquipmentTypeId;
    }

    public void setLyyEquipmentTypeId(Integer lyyEquipmentTypeId) {
        this.lyyEquipmentTypeId = lyyEquipmentTypeId;
    }

    @Override
    public String toString() {
        return "TemplateAdvVo{" +
                "isSingle='" + isSingle + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", lyyEquipmentTypeId=" + lyyEquipmentTypeId +
                '}';
    }

}

