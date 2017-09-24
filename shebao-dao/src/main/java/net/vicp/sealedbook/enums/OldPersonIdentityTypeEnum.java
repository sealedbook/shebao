/**
 * Copyright (c) 2017, TalkingData and/or its affiliates. All rights reserved.
 */
package net.vicp.sealedbook.enums;

import net.vicp.sealedbook.common.enums.IEnum;
import net.vicp.sealedbook.common.utils.EnumUtils;

/**
 * @author shitianshu on 2017/9/24 下午10:44.
 */
public enum OldPersonIdentityTypeEnum implements IEnum<Integer> {

    WORKING_PERSON(1, "从业人员"),
    CHENG_JI_BAO(2, "城基保"),
    XIN_NONG_BAO(3, "新农保");

    private int value;
    private String title;

    OldPersonIdentityTypeEnum(int value, String title) {
        this.value = value;
        this.title = title;
    }

    public static OldPersonIdentityTypeEnum create(Integer value) {
        return EnumUtils.getEnum(OldPersonIdentityTypeEnum.values(), value);
    }

    public Integer getValue() {
        return value;
    }

    public String getTitle() {
        return title;
    }

}