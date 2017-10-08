/**
 * Copyright (c) 2017, TalkingData and/or its affiliates. All rights reserved.
 */
package net.vicp.sealedbook.handler.system;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import net.vicp.sealedbook.common.utils.LogUtils;
import net.vicp.sealedbook.dao.auto.model.SystemRoleFunctionMapperMo;
import net.vicp.sealedbook.dao.dataprovider.system.SystemRoleFunctionMapperProvider;

/**
 * @author shitianshu on 2017/10/2 下午4:31.
 */
@Service
public class SystemRoleFunctionMapperHandler {

    /** 日志 */
    private static final Logger LOG = LoggerFactory.getLogger(SystemRoleFunctionMapperHandler.class);

    @Resource
    private SystemRoleFunctionMapperProvider systemRoleFunctionMapperProvider;

    public List<SystemRoleFunctionMapperMo> fetchRoleFunctionByRoleId(int roleId) {
        List<SystemRoleFunctionMapperMo> systemRoleFunctionMapperMoList = null;

        try {
            systemRoleFunctionMapperMoList = systemRoleFunctionMapperProvider.fetchRoleFunctionByRoleId(roleId);
        } catch (Throwable e) {
            LogUtils.error(LOG, e, "fetch role and function mapper error.", "roleId", roleId);
        }
        return systemRoleFunctionMapperMoList;
    }
}
