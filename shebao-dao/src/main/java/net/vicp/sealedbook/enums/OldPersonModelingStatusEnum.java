/**
 * Copyright (c) 2017, TalkingData and/or its affiliates. All rights reserved.
 */
package net.vicp.sealedbook.enums;

import net.vicp.sealedbook.common.enums.IEnum;
import net.vicp.sealedbook.common.utils.EnumUtils;

/**
 * 老年人建模状态
 *
 * @author shitianshu on 2017/9/24 下午11:19.
 */
public enum OldPersonModelingStatusEnum implements IEnum<Integer> {

    UN_MODEL(1, "未建模"),
    MODELED(2, "已建模"),
    CAN_NOT_MODEL(3, "无法建模");

    private int value;
    private String title;

    OldPersonModelingStatusEnum(int value, String title) {
        this.value = value;
        this.title = title;
    }

    public static OldPersonModelingStatusEnum create(Integer value) {
        return EnumUtils.getEnum(OldPersonModelingStatusEnum.values(), value);
    }

    public Integer getValue() {
        return value;
    }

    public String getTitle() {
        return title;
    }

}