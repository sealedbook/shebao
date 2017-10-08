/**
 * Copyright (c) 2017, TalkingData and/or its affiliates. All rights reserved.
 */
package net.vicp.sealedbook.entity;

import javax.servlet.http.HttpServletRequest;

import net.vicp.sealedbook.common.consts.SystemConst;
import net.vicp.sealedbook.entity.dto.SystemUserDTO;

/**
 * @author shitianshu on 2017/10/2 上午10:35.
 */
public class Customer {

    private SystemUserDTO user;
    private String ip;
    private String userAgent;

    public Customer(HttpServletRequest request) {
        Object obj = request.getSession().getAttribute(SystemConst.SESSION_USER_KEY);
        if (null == obj) {
            throw new RuntimeException("还没有登录系统");
        }
        if (obj instanceof SystemUserDTO) {
            this.user = (SystemUserDTO) obj;
        }
        this.ip = request.getRemoteAddr();
        this.userAgent = request.getHeader("User-Agent");
    }

    public SystemUserDTO getUser() {
        return user;
    }

    public String getIp() {
        return ip;
    }

    public String getUserAgent() {
        return userAgent;
    }

}
