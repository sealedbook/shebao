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
import net.vicp.sealedbook.dao.auto.model.SystemRoleMo;
import net.vicp.sealedbook.dao.dataprovider.system.SystemRoleProvider;

/**
 * 系统角色服务
 *
 * @author shitianshu on 2017/10/2 上午9:54.
 */
@Service
public class SystemRoleHandler {

    private static final Logger LOG = LoggerFactory.getLogger(SystemRoleHandler.class);

    @Resource
    private SystemRoleProvider systemRoleProvider;

    /**
     * 通过角色id获得角色信息
     *
     * @param roleId
     * @return
     */
    public SystemRoleMo fetchRoleById(int roleId) {
        if (roleId <= 0) {
            return null;
        }
        SystemRoleMo systemRole = null;
        try {
            systemRole = systemRoleProvider.fetchRoleById(roleId);
            LogUtils.debug(LOG, "fetch system role by id", "roleId", roleId, "systemRole", systemRole);
        } catch (DataBaseException e) {
            LogUtils.error(LOG, e,"fetch system role by id error.");
        }
        return systemRole;
    }

    /**
     * 获得系统中所有的角色信息
     *
     * @return
     */
    public List<SystemRoleMo> fetchAllRole() {
        List<SystemRoleMo> systemRoleList = null;
        try {
            systemRoleList = systemRoleProvider.fetchAll();
        } catch (DataBaseException e) {
            LogUtils.error(LOG, e,"fetch all role error");
        }
        return systemRoleList;
    }

}
