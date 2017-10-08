/**
 * Copyright (c) 2017, TalkingData and/or its affiliates. All rights reserved.
 */
package net.vicp.sealedbook.handler.system;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import net.vicp.sealedbook.common.exception.DataBaseException;
import net.vicp.sealedbook.common.utils.LogUtils;
import net.vicp.sealedbook.dao.auto.model.SystemUserMo;
import net.vicp.sealedbook.dao.dataprovider.system.SystemUserProvider;

/**
 * 系统用户服务处理
 *
 * @author shitianshu on 2017/10/2 上午9:08.
 */
@Service
public class SystemUserHandler {

    /**
     * 日志
     */
    private static Logger LOG = LoggerFactory.getLogger(SystemUserHandler.class);

    @Resource
    private SystemUserProvider systemUserProvider;

    /**
     * 根据登录账号获得系统用户
     *
     * @param account
     * @return
     */
    public SystemUserMo fetchUserByAccount(String account) {
        if (!StringUtils.hasText(account)) {
            return null;
        }
        List<SystemUserMo> systemUserMoList = null;
        try {
            systemUserMoList = systemUserProvider.fetchUserByAccount(account);
        } catch (DataBaseException e) {
            LogUtils.error(LOG, e, "fetch user by account error.", "account", account);
        }
        if (null == systemUserMoList || systemUserMoList.isEmpty()) {
            return null;
        }
        if (systemUserMoList.size() > 1) {
            LogUtils.warn(LOG, "multiple account", "account", account);
        }
        return systemUserMoList.get(0);
    }
}
