/**
 * Copyright (c) 2017, TalkingData and/or its affiliates. All rights reserved.
 */
package net.vicp.sealedbook.enums;

import net.vicp.sealedbook.common.enums.IEnum;
import net.vicp.sealedbook.common.utils.EnumUtils;

/**
 * 老年人发放状态
 *
 * @author shitianshu on 2017/9/24 下午11:02.
 */
public enum OldPersonPushStatusEnum implements IEnum<Integer> {

    UN_PUSH(1, "未发放"),
    PUSHABLE(2, "可发放"),
    PAUSE_PUSH(3, "暂停发放"),
    NPO_PUSH(4, "不发放");

    private int value;
    private String title;

    OldPersonPushStatusEnum(int value, String title) {
        this.value = value;
        this.title = title;
    }

    public static OldPersonPushStatusEnum create(Integer value) {
        return EnumUtils.getEnum(OldPersonPushStatusEnum.values(), value);
    }

    public Integer getValue() {
        return value;
    }

    public String getTitle() {
        return title;
    }

}