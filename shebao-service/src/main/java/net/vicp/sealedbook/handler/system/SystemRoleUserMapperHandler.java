/**
 * Copyright (c) 2017, TalkingData and/or its affiliates. All rights reserved.
 */
package net.vicp.sealedbook.handler.system;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import net.vicp.sealedbook.common.exception.DataBaseException;
import net.vicp.sealedbook.common.utils.LogUtils;
import net.vicp.sealedbook.dao.auto.model.SystemRoleUserMapperMo;
import net.vicp.sealedbook.dao.dataprovider.system.SystemRoleUserMapperProvider;

/**
 * 系统用户和角色映射关系
 *
 * @author shitianshu on 2017/10/2 上午10:03.
 */
@Service
public class SystemRoleUserMapperHandler {

    /**
     * 日志
     */
    private static final Logger LOG = LoggerFactory.getLogger(SystemRoleUserMapperHandler.class);

    @Resource
    private SystemRoleUserMapperProvider systemRoleUserMapperProvider;

    /**
     * 通过系统用户ID 获得映射的角色ID
     */
    public List<SystemRoleUserMapperMo> fetchRoleIdInMapper(Integer systemUserId) {
        try {
            List<SystemRoleUserMapperMo> systemRoleUserMapperList = systemRoleUserMapperProvider
                .fetchRoleIdInMapper(systemUserId);
            LogUtils.debug(LOG, "fetch role user mapper", "systemUserId", systemUserId, "mapper", systemRoleUserMapperList);
            return systemRoleUserMapperList;
        } catch (DataBaseException e) {
            LogUtils.error(LOG, e, "fetch role user mapper error.");
        }
        return null;
    }
}
