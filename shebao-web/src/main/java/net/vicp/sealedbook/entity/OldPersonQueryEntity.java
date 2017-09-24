/**
 * Copyright (c) 2017, TalkingData and/or its affiliates. All rights reserved.
 */
package net.vicp.sealedbook.entity;

/**
 * @author shitianshu on 2017/9/24 上午11:31.
 */
public class OldPersonQueryEntity {

    private String idCard;
    private String name;
    private int sex = -1;
    private int type = -1;
    private String status = "";
    private String areaId;
    private String ageRange;
    private int ageRangeBegin = -1;
    private int ageRangeEnd = -1;
    private String modelingStatus;

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(String ageRange) {
        this.ageRange = ageRange;
    }

    public int getAgeRangeBegin() {
        return ageRangeBegin;
    }

    public void setAgeRangeBegin(int ageRangeBegin) {
        this.ageRangeBegin = ageRangeBegin;
    }

    public int getAgeRangeEnd() {
        return ageRangeEnd;
    }

    public void setAgeRangeEnd(int ageRangeEnd) {
        this.ageRangeEnd = ageRangeEnd;
    }

    public String getModelingStatus() {
        return modelingStatus;
    }

    public void setModelingStatus(String modelingStatus) {
        this.modelingStatus = modelingStatus;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OldPersonQueryEntity{");
        sb.append("idCard='").append(idCard).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", sex=").append(sex);
        sb.append(", type=").append(type);
        sb.append(", status='").append(status).append('\'');
        sb.append(", areaId='").append(areaId).append('\'');
        sb.append(", ageRange='").append(ageRange).append('\'');
        sb.append(", ageRangeBegin=").append(ageRangeBegin);
        sb.append(", ageRangeEnd=").append(ageRangeEnd);
        sb.append(", modelingStatus='").append(modelingStatus).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
