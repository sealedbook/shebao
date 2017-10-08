/**
 * Copyright (c) 2017, TalkingData and/or its affiliates. All rights reserved.
 */
package net.vicp.sealedbook.processor.system;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import net.vicp.sealedbook.dao.auto.model.SystemRoleMo;
import net.vicp.sealedbook.dao.auto.model.SystemUserMo;
import net.vicp.sealedbook.entity.dto.SystemUserDTO;
import net.vicp.sealedbook.handler.system.SystemUserHandler;

/**
 * 系统用户处理
 *
 * @author shitianshu on 2017/10/2 上午8:27.
 */
@Service
public class SystemUserProcessor {

    /** 日志 */
    private static final Logger LOG = LoggerFactory.getLogger(SystemUserProcessor.class);

    @Resource
    private SystemUserHandler systemUserHandler;

    @Resource
    private SystemRoleProcessor systemRoleProcessor;

    /**
     * 系统用户登录
     *
     * @param systemUser
     * @return
     */
    public SystemUserDTO login(SystemUserDTO systemUser) {
        if (null == systemUser) {
            throw new IllegalArgumentException("用户不存在");
        }

        if (!StringUtils.hasText(systemUser.getAccount())) {
            throw new IllegalArgumentException("请提供账号");
        }

        if (!StringUtils.hasText(systemUser.getPassword())) {
            throw new IllegalArgumentException("请提供密码");
        }

        SystemUserMo systemUserFromDB = systemUserHandler.fetchUserByAccount(systemUser.getAccount());
        if (null == systemUserFromDB) {
            throw new IllegalArgumentException("用户名/密码错误.");
        }

        if (!systemUser.getPassword().equals(systemUserFromDB.getPassword())) {
            throw new IllegalArgumentException("用户名/密码错误.");
        }

        /** 处理用户角色 */
        List<SystemRoleMo> systemRoleList = systemRoleProcessor.fetchRoleByUserId(systemUserFromDB.getId());
        if (null == systemRoleList || systemRoleList.isEmpty()) {
            throw new IllegalArgumentException("该账号还不属于任何角色,请联系管理员进行分配.");
        }

        systemUser.setId(systemUserFromDB.getId());
        systemUser.setIdCard(systemUserFromDB.getIdCard());
        systemUser.setShowName(systemUserFromDB.getShowName());
        if (null != systemUserFromDB.getSex()) {
            systemUser.setSex(systemUserFromDB.getSex().getValue());
        }
        systemUser.setRoleCollection(systemRoleList);

        return systemUser;
    }
}
