/**
 * Copyright (c) 2017, TalkingData and/or its affiliates. All rights reserved.
 */
package net.vicp.sealedbook.controller.mission;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.vicp.sealedbook.common.consts.SystemConst;

/**
 * @author shitianshu on 2017/9/25 上午12:31.
 */
@Controller
@RequestMapping("/http/notice")
public class NoticeController {

    @RequestMapping("/receive")
    public @ResponseBody
    Map<String, Object> receive(String noticeId, HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            String imei = request.getParameter(SystemConst.TERMINAL_IMEI);
            //noticeReceiveService.receive(noticeId,imei,new Customer(request));
            resultMap.put("responseStatus", "OK");
        } catch (IllegalArgumentException e) {
            resultMap.put("responseStatus", "ERROR");
            resultMap.put("errorMessage", e.getMessage());
        }
        return resultMap;
    }

}
