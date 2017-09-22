/**
 * Copyright (c) 2017, TalkingData and/or its affiliates. All rights reserved.
 */
package net.vicp.sealedbook.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author shitianshu on 2017/6/20 下午5:22.
 */
@Controller
public class SystemController {

    private static final Logger LOG = LoggerFactory.getLogger(SystemController.class);

    @ResponseBody
    @RequestMapping("/ruok")
    public String available() {
        return "OK";
    }

}
