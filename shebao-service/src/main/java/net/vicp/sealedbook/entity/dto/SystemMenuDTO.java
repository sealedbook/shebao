/**
 * Copyright (c) 2017, TalkingData and/or its affiliates. All rights reserved.
 */
package net.vicp.sealedbook.entity.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import net.vicp.sealedbook.dao.auto.model.SystemFunctionMo;

/**
 * @author shitianshu on 2017/10/2 上午11:38.
 */
public class SystemMenuDTO implements Serializable, Comparable<SystemMenuDTO>, IConvertToEasyUITree<SystemMenuDTO> {

    private int id;
    private String name;
    private String url;
    private String icon;
    private int order;
    private List<SystemFunctionMo> subFunction = new ArrayList<SystemFunctionMo>();
    private List<SystemMenuDTO> subSystemMenu = new ArrayList<SystemMenuDTO>();

    public SystemMenuDTO() {
    }

    public SystemMenuDTO(SystemMenuDTO systemMenu) {
        this.id = systemMenu.id;
        this.name = systemMenu.name;
        this.url = systemMenu.url;
        this.icon = systemMenu.icon;
        this.order = systemMenu.order;
        this.subFunction = systemMenu.subFunction;
    }

    public int getSubSystemMenuSize() {
        if(null == subSystemMenu) {
            return 0;
        }
        return subSystemMenu.size();
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public List<SystemFunctionMo> getSubFunction() {
        return subFunction;
    }

    public void setSubFunction(List<SystemFunctionMo> subFunction) {
        this.subFunction = subFunction;
    }

    public List<SystemMenuDTO> getSubSystemMenu() {
        return subSystemMenu;
    }

    public void setSubSystemMenu(List<SystemMenuDTO> subSystemMenu) {
        this.subSystemMenu = subSystemMenu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SystemMenuDTO that = (SystemMenuDTO) o;

        if (id != that.id) {
            return false;
        }
        if (order != that.order) {
            return false;
        }
        if (name != null ? !name.equals(that.name) : that.name != null) {
            return false;
        }
        if (url != null ? !url.equals(that.url) : that.url != null) {
            return false;
        }
        if (icon != null ? !icon.equals(that.icon) : that.icon != null) {
            return false;
        }
        if (subFunction != null ? !subFunction.equals(that.subFunction) : that.subFunction != null) {
            return false;
        }
        return subSystemMenu != null ? subSystemMenu.equals(that.subSystemMenu) : that.subSystemMenu == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (icon != null ? icon.hashCode() : 0);
        result = 31 * result + order;
        result = 31 * result + (subFunction != null ? subFunction.hashCode() : 0);
        result = 31 * result + (subSystemMenu != null ? subSystemMenu.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(SystemMenuDTO systemMenu) {
        return this.order - systemMenu.order;
    }

    @Override
    public String getText() {
        return this.name;
    }

    @Override
    public List<SystemMenuDTO> getChildren() {
        return this.subSystemMenu;
    }

    @Override
    public String getState() {
        return "open";
    }

    @Override
    public boolean getChecked() {
        return false;
    }

}
