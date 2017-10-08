/**
 * Copyright (c) 2017, TalkingData and/or its affiliates. All rights reserved.
 */
package net.vicp.sealedbook.entity.dto;


import java.util.List;

import net.vicp.sealedbook.dao.auto.model.SystemRoleMo;

/**
 * @author shitianshu on 2017/10/2 上午10:23.
 */
public class SystemUserDTO {

    /**
     *
     */
    private Integer id;

    /**
     * 登录账号
     */
    private String account;

    /**
     * 系统中显示名称
     */
    private String showName;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 性别
     */
    private int sex;

    /** 用户角色 **/
    private List<SystemRoleMo> roleCollection;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public List<SystemRoleMo> getRoleCollection() {
        return roleCollection;
    }

    public void setRoleCollection(List<SystemRoleMo> roleCollection) {
        this.roleCollection = roleCollection;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SystemUserDTO{");
        sb.append("id=").append(id);
        sb.append(", account='").append(account).append('\'');
        sb.append(", showName='").append(showName).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", idCard='").append(idCard).append('\'');
        sb.append(", sex=").append(sex);
        sb.append(", roleCollection=").append(roleCollection);
        sb.append('}');
        return sb.toString();
    }
}
