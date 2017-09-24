/**
 * Copyright (c) 2017, TalkingData and/or its affiliates. All rights reserved.
 */
package net.vicp.sealedbook.enums;

import net.vicp.sealedbook.common.enums.IEnum;
import net.vicp.sealedbook.common.utils.EnumUtils;

/**
 * @author shitianshu on 2017/9/24 下午10:32.
 */
public enum OldPersonTypeEnum implements IEnum<Integer> {

    LOCAL_PERSON(1, "本地老年人"),
    OUTSIDER_PERSON(2, "外地老年人");

    private int value;
    private String title;

    OldPersonTypeEnum(int value, String title) {
        this.value = value;
        this.title = title;
    }

    public static OldPersonTypeEnum create(Integer value) {
        return EnumUtils.getEnum(OldPersonTypeEnum.values(), value);
    }

    public Integer getValue() {
        return value;
    }

    public String getTitle() {
        return title;
    }

}
