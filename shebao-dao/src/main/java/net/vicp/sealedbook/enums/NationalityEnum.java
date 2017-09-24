/**
 * Copyright (c) 2017, TalkingData and/or its affiliates. All rights reserved.
 */
package net.vicp.sealedbook.enums;

import net.vicp.sealedbook.common.enums.IEnum;
import net.vicp.sealedbook.common.utils.EnumUtils;

/**
 * @author shitianshu on 2017/9/24 下午10:38.
 */
public enum  NationalityEnum implements IEnum<Integer> {

    HAN(1, "汉族"),
    HUI(2, "回族");

    private int value;
    private String title;

    NationalityEnum(int value, String title) {
        this.value = value;
        this.title = title;
    }

    public static NationalityEnum create(Integer value) {
        return EnumUtils.getEnum(NationalityEnum.values(), value);
    }

    public Integer getValue() {
        return value;
    }

    public String getTitle() {
        return title;
    }

}
