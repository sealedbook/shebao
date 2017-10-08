/**
 * Copyright (c) 2017, TalkingData and/or its affiliates. All rights reserved.
 */
package net.vicp.sealedbook.controller.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

import net.vicp.sealedbook.common.consts.SystemConst;
import net.vicp.sealedbook.common.utils.LogUtils;
import net.vicp.sealedbook.common.utils.WebRequestHelper;
import net.vicp.sealedbook.entity.dto.SystemMenuDTO;
import net.vicp.sealedbook.entity.dto.SystemUserDTO;
import net.vicp.sealedbook.processor.system.SystemMenuProcessor;
import net.vicp.sealedbook.processor.system.SystemUserProcessor;

/**
 * @author shitianshu on 2017/9/30 上午10:11.
 */
@Controller
public class SecurityController {

    private static final Logger LOG = LoggerFactory.getLogger(SecurityController.class);

    @Resource
    private SystemUserProcessor systemUserProcessor;
    @Resource
    private SystemMenuProcessor systemMenuProcessor;

    /** 登录页面跳转 */
    @RequestMapping("/security/login/page")
    public String loginPage() {
        LogUtils.info(LOG, "login page open");
        return "/login";
    }

    /**
     * 系统用户登录
     * @param systemUser
     * @param session
     * @param request
     * @return
     */
    @RequestMapping("/security/login")
    public ResponseEntity<String> login(SystemUserDTO systemUser, HttpSession session, HttpServletRequest request) {
        String errorMessage;
        try {
            systemUser = systemUserProcessor.login(systemUser);
            session.setAttribute(SystemConst.SESSION_USER_KEY, systemUser);
            if (WebRequestHelper.isWebClient(request)) {
                return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
            }
            int token = systemUser.getId();
            request.getServletContext()
                .setAttribute(SystemConst.SERVLET_OPERATOR_TOKEN_KEY_PREFIX + token, systemUser);
            Map<String, Object> m = new HashMap<String, Object>();
            m.put("token", token);
            m.put("user", systemUser);
            String responseBodyString = new Gson().toJson(m);
            LOG.info("终端已经正常登录.获得令牌:" + token);
            return new ResponseEntity<String>(responseBodyString, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            errorMessage = e.getMessage();
        } catch (Exception e) {
            errorMessage = e.getMessage();
        }
        return new ResponseEntity<String>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    /**
     * 权限管理页
     * @param model
     * @return
     */
    @RequestMapping(value="/system/security/manager")
    public String securityManager(Model model){
        List<SystemMenuDTO> systemMenu = systemMenuProcessor.getSystemMenu();
        model.addAttribute("menu", systemMenu);
        return "/system/security/manager";
    }



    @RequestMapping("/security/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/security/login/page.do";
    }
}
