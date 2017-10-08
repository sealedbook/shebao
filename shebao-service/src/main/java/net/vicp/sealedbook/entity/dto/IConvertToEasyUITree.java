/**
 * Copyright (c) 2017, TalkingData and/or its affiliates. All rights reserved.
 */
package net.vicp.sealedbook.entity.dto;

/**
 * @author shitianshu on 2017/10/2 下午3:25.
 */
public interface IConvertToEasyUITree<T> {

    public int getId();

    public String getText();

    public String getState();

    public boolean getChecked();

    public Iterable<T> getChildren();


}
