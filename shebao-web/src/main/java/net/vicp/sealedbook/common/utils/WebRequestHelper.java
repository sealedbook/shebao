/**
 * Copyright (c) 2017, TalkingData and/or its affiliates. All rights reserved.
 */
package net.vicp.sealedbook.common.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author shitianshu on 2017/10/2 上午9:30.
 */
public class WebRequestHelper {

    public static boolean isWebClient(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");
        if(userAgent.toUpperCase().contains("OLD_PERSON_ANDROID_TERMINAL")) {
            return false;
        }
        return true;
    }
    
}
