package net.vicp.sealedbook.dao.auto.model;

import java.util.Date;
import net.vicp.sealedbook.common.enums.GenderEnum;
import net.vicp.sealedbook.common.utils.BaseEntity;
import net.vicp.sealedbook.enums.NationalityEnum;
import net.vicp.sealedbook.enums.OldPersonModelingStatusEnum;
import net.vicp.sealedbook.enums.OldPersonPushStatusEnum;
import net.vicp.sealedbook.enums.OldPersonStatusEnum;
import net.vicp.sealedbook.enums.OldPersonTypeEnum;

public class OldPersonMo extends BaseEntity {
    /**
     * 
     */
    private Integer id;

    /**
     * 老年人姓名
     */
    private String name;

    /**
     * 老年人姓名拼音
     */
    private String nameSpell;

    /**
     * 老年人身份证号
     */
    private String idCard;

    /**
     * 社保号
     */
    private String socialNumber;

    /**
     * 性别
     */
    private GenderEnum sex;

    /**
     * 出生日期
     */
    private Date birthday;

    /**
     * 民族
     */
    private NationalityEnum nationality;

    /**
     * 根目录区域id(镇级)
     */
    private String rootAreaId;

    /**
     * 
     */
    private String areaId;

    /**
     * 家庭住址
     */
    private String homeAddress;

    /**
     * 身份类型
     */
    private Integer identityType;

    /**
     * 电话号码
     */
    private String phoneNumber;

    /**
     * 工作单位
     */
    private String workUnit;

    /**
     * 老年人类别，本地用户、外地用户
     */
    private OldPersonTypeEnum type;

    /**
     * 数据入库时间
     */
    private Date sysInsertDatetime;

    /**
     * 老年人状态,正常、死亡、删除
     */
    private OldPersonStatusEnum status;

    /**
     * 老年照片Key
     */
    private String photoKey;

    /**
     * 
     */
    private String batchId;

    /**
     * 建模状态
     */
    private OldPersonModelingStatusEnum modelingStatus;

    /**
     * 发放状态
     */
    private OldPersonPushStatusEnum ffStatus;

    /**
     * @return the value of old_person.id
     * 
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the value for old_person.id
     * 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the value of old_person.name
     * 老年人姓名
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the value for old_person.name
     * 老年人姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return the value of old_person.name_spell
     * 老年人姓名拼音
     */
    public String getNameSpell() {
        return nameSpell;
    }

    /**
     * @param nameSpell the value for old_person.name_spell
     * 老年人姓名拼音
     */
    public void setNameSpell(String nameSpell) {
        this.nameSpell = nameSpell == null ? null : nameSpell.trim();
    }

    /**
     * @return the value of old_person.id_card
     * 老年人身份证号
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * @param idCard the value for old_person.id_card
     * 老年人身份证号
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    /**
     * @return the value of old_person.social_number
     * 社保号
     */
    public String getSocialNumber() {
        return socialNumber;
    }

    /**
     * @param socialNumber the value for old_person.social_number
     * 社保号
     */
    public void setSocialNumber(String socialNumber) {
        this.socialNumber = socialNumber == null ? null : socialNumber.trim();
    }

    /**
     * @return the value of old_person.sex
     * 性别
     */
    public GenderEnum getSex() {
        return sex;
    }

    /**
     * @param sex the value for old_person.sex
     * 性别
     */
    public void setSex(GenderEnum sex) {
        this.sex = sex;
    }

    /**
     * @return the value of old_person.birthday
     * 出生日期
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the value for old_person.birthday
     * 出生日期
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @return the value of old_person.nationality
     * 民族
     */
    public NationalityEnum getNationality() {
        return nationality;
    }

    /**
     * @param nationality the value for old_person.nationality
     * 民族
     */
    public void setNationality(NationalityEnum nationality) {
        this.nationality = nationality;
    }

    /**
     * @return the value of old_person.ROOT_AREA_ID
     * 根目录区域id(镇级)
     */
    public String getRootAreaId() {
        return rootAreaId;
    }

    /**
     * @param rootAreaId the value for old_person.ROOT_AREA_ID
     * 根目录区域id(镇级)
     */
    public void setRootAreaId(String rootAreaId) {
        this.rootAreaId = rootAreaId == null ? null : rootAreaId.trim();
    }

    /**
     * @return the value of old_person.AREA_ID
     * 
     */
    public String getAreaId() {
        return areaId;
    }

    /**
     * @param areaId the value for old_person.AREA_ID
     * 
     */
    public void setAreaId(String areaId) {
        this.areaId = areaId == null ? null : areaId.trim();
    }

    /**
     * @return the value of old_person.home_address
     * 家庭住址
     */
    public String getHomeAddress() {
        return homeAddress;
    }

    /**
     * @param homeAddress the value for old_person.home_address
     * 家庭住址
     */
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress == null ? null : homeAddress.trim();
    }

    /**
     * @return the value of old_person.identity_type
     * 身份类型
     */
    public Integer getIdentityType() {
        return identityType;
    }

    /**
     * @param identityType the value for old_person.identity_type
     * 身份类型
     */
    public void setIdentityType(Integer identityType) {
        this.identityType = identityType;
    }

    /**
     * @return the value of old_person.phone_number
     * 电话号码
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the value for old_person.phone_number
     * 电话号码
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    /**
     * @return the value of old_person.work_unit
     * 工作单位
     */
    public String getWorkUnit() {
        return workUnit;
    }

    /**
     * @param workUnit the value for old_person.work_unit
     * 工作单位
     */
    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit == null ? null : workUnit.trim();
    }

    /**
     * @return the value of old_person.type
     * 老年人类别，本地用户、外地用户
     */
    public OldPersonTypeEnum getType() {
        return type;
    }

    /**
     * @param type the value for old_person.type
     * 老年人类别，本地用户、外地用户
     */
    public void setType(OldPersonTypeEnum type) {
        this.type = type;
    }

    /**
     * @return the value of old_person.sys_insert_datetime
     * 数据入库时间
     */
    public Date getSysInsertDatetime() {
        return sysInsertDatetime;
    }

    /**
     * @param sysInsertDatetime the value for old_person.sys_insert_datetime
     * 数据入库时间
     */
    public void setSysInsertDatetime(Date sysInsertDatetime) {
        this.sysInsertDatetime = sysInsertDatetime;
    }

    /**
     * @return the value of old_person.status
     * 老年人状态,正常、死亡、删除
     */
    public OldPersonStatusEnum getStatus() {
        return status;
    }

    /**
     * @param status the value for old_person.status
     * 老年人状态,正常、死亡、删除
     */
    public void setStatus(OldPersonStatusEnum status) {
        this.status = status;
    }

    /**
     * @return the value of old_person.photo_key
     * 老年照片Key
     */
    public String getPhotoKey() {
        return photoKey;
    }

    /**
     * @param photoKey the value for old_person.photo_key
     * 老年照片Key
     */
    public void setPhotoKey(String photoKey) {
        this.photoKey = photoKey == null ? null : photoKey.trim();
    }

    /**
     * @return the value of old_person.BATCH_ID
     * 
     */
    public String getBatchId() {
        return batchId;
    }

    /**
     * @param batchId the value for old_person.BATCH_ID
     * 
     */
    public void setBatchId(String batchId) {
        this.batchId = batchId == null ? null : batchId.trim();
    }

    /**
     * @return the value of old_person.modeling_status
     * 建模状态
     */
    public OldPersonModelingStatusEnum getModelingStatus() {
        return modelingStatus;
    }

    /**
     * @param modelingStatus the value for old_person.modeling_status
     * 建模状态
     */
    public void setModelingStatus(OldPersonModelingStatusEnum modelingStatus) {
        this.modelingStatus = modelingStatus;
    }

    /**
     * @return the value of old_person.ff_status
     * 发放状态
     */
    public OldPersonPushStatusEnum getFfStatus() {
        return ffStatus;
    }

    /**
     * @param ffStatus the value for old_person.ff_status
     * 发放状态
     */
    public void setFfStatus(OldPersonPushStatusEnum ffStatus) {
        this.ffStatus = ffStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table old_person
     *
     * @mbggenerated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        OldPersonMo other = (OldPersonMo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getNameSpell() == null ? other.getNameSpell() == null : this.getNameSpell().equals(other.getNameSpell()))
            && (this.getIdCard() == null ? other.getIdCard() == null : this.getIdCard().equals(other.getIdCard()))
            && (this.getSocialNumber() == null ? other.getSocialNumber() == null : this.getSocialNumber().equals(other.getSocialNumber()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getNationality() == null ? other.getNationality() == null : this.getNationality().equals(other.getNationality()))
            && (this.getRootAreaId() == null ? other.getRootAreaId() == null : this.getRootAreaId().equals(other.getRootAreaId()))
            && (this.getAreaId() == null ? other.getAreaId() == null : this.getAreaId().equals(other.getAreaId()))
            && (this.getHomeAddress() == null ? other.getHomeAddress() == null : this.getHomeAddress().equals(other.getHomeAddress()))
            && (this.getIdentityType() == null ? other.getIdentityType() == null : this.getIdentityType().equals(other.getIdentityType()))
            && (this.getPhoneNumber() == null ? other.getPhoneNumber() == null : this.getPhoneNumber().equals(other.getPhoneNumber()))
            && (this.getWorkUnit() == null ? other.getWorkUnit() == null : this.getWorkUnit().equals(other.getWorkUnit()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getSysInsertDatetime() == null ? other.getSysInsertDatetime() == null : this.getSysInsertDatetime().equals(other.getSysInsertDatetime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getPhotoKey() == null ? other.getPhotoKey() == null : this.getPhotoKey().equals(other.getPhotoKey()))
            && (this.getBatchId() == null ? other.getBatchId() == null : this.getBatchId().equals(other.getBatchId()))
            && (this.getModelingStatus() == null ? other.getModelingStatus() == null : this.getModelingStatus().equals(other.getModelingStatus()))
            && (this.getFfStatus() == null ? other.getFfStatus() == null : this.getFfStatus().equals(other.getFfStatus()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table old_person
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getNameSpell() == null) ? 0 : getNameSpell().hashCode());
        result = prime * result + ((getIdCard() == null) ? 0 : getIdCard().hashCode());
        result = prime * result + ((getSocialNumber() == null) ? 0 : getSocialNumber().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getNationality() == null) ? 0 : getNationality().hashCode());
        result = prime * result + ((getRootAreaId() == null) ? 0 : getRootAreaId().hashCode());
        result = prime * result + ((getAreaId() == null) ? 0 : getAreaId().hashCode());
        result = prime * result + ((getHomeAddress() == null) ? 0 : getHomeAddress().hashCode());
        result = prime * result + ((getIdentityType() == null) ? 0 : getIdentityType().hashCode());
        result = prime * result + ((getPhoneNumber() == null) ? 0 : getPhoneNumber().hashCode());
        result = prime * result + ((getWorkUnit() == null) ? 0 : getWorkUnit().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getSysInsertDatetime() == null) ? 0 : getSysInsertDatetime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getPhotoKey() == null) ? 0 : getPhotoKey().hashCode());
        result = prime * result + ((getBatchId() == null) ? 0 : getBatchId().hashCode());
        result = prime * result + ((getModelingStatus() == null) ? 0 : getModelingStatus().hashCode());
        result = prime * result + ((getFfStatus() == null) ? 0 : getFfStatus().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table old_person
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", nameSpell=").append(nameSpell);
        sb.append(", idCard=").append(idCard);
        sb.append(", socialNumber=").append(socialNumber);
        sb.append(", sex=").append(sex);
        sb.append(", birthday=").append(birthday);
        sb.append(", nationality=").append(nationality);
        sb.append(", rootAreaId=").append(rootAreaId);
        sb.append(", areaId=").append(areaId);
        sb.append(", homeAddress=").append(homeAddress);
        sb.append(", identityType=").append(identityType);
        sb.append(", phoneNumber=").append(phoneNumber);
        sb.append(", workUnit=").append(workUnit);
        sb.append(", type=").append(type);
        sb.append(", sysInsertDatetime=").append(sysInsertDatetime);
        sb.append(", status=").append(status);
        sb.append(", photoKey=").append(photoKey);
        sb.append(", batchId=").append(batchId);
        sb.append(", modelingStatus=").append(modelingStatus);
        sb.append(", ffStatus=").append(ffStatus);
        sb.append("]");
        return sb.toString();
    }
}