/**
 * Copyright (c) 2017, TalkingData and/or its affiliates. All rights reserved.
 */
package net.vicp.sealedbook.enums;

import net.vicp.sealedbook.common.enums.IEnum;
import net.vicp.sealedbook.common.utils.EnumUtils;

/**
 * 系统请求资源类型
 *
 * @author shitianshu on 2017/10/2 上午11:08.
 */
public enum  SystemResourceTypeEnum implements IEnum<Integer> {

    PRIVATE_RESOURCE(0, "私有资源"),
    PUBLIC_RESOURCE(1, "公共资源");

    private int value;
    private String title;

    SystemResourceTypeEnum(int value, String title) {
        this.value = value;
        this.title = title;
    }

    public static SystemResourceTypeEnum create(Integer value) {
        return EnumUtils.getEnum(SystemResourceTypeEnum.values(), value);
    }

    public Integer getValue() {
        return value;
    }

    public String getTitle() {
        return title;
    }


}
