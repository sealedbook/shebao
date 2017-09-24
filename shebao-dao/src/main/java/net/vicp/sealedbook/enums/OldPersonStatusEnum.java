/**
 * Copyright (c) 2017, TalkingData and/or its affiliates. All rights reserved.
 */
package net.vicp.sealedbook.enums;

import net.vicp.sealedbook.common.enums.IEnum;
import net.vicp.sealedbook.common.utils.EnumUtils;

/**
 * 老年人录入状态
 *
 * @author shitianshu on 2017/9/24 下午10:49.
 */
public enum OldPersonStatusEnum implements IEnum<Integer> {

    OK(1, "正常"),
    DELETE(2, "删除"),
    DIED(3, "死亡");

    private int value;
    private String title;

    OldPersonStatusEnum(int value, String title) {
        this.value = value;
        this.title = title;
    }

    public static OldPersonStatusEnum create(Integer value) {
        return EnumUtils.getEnum(OldPersonStatusEnum.values(), value);
    }

    public Integer getValue() {
        return value;
    }

    public String getTitle() {
        return title;
    }

}
