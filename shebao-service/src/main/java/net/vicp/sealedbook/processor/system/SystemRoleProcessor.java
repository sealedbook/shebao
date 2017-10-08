/**
 * Copyright (c) 2017, TalkingData and/or its affiliates. All rights reserved.
 */
package net.vicp.sealedbook.processor.system;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import net.vicp.sealedbook.dao.auto.model.SystemRoleMo;
import net.vicp.sealedbook.dao.auto.model.SystemRoleUserMapperMo;
import net.vicp.sealedbook.handler.system.SystemRoleHandler;
import net.vicp.sealedbook.handler.system.SystemRoleUserMapperHandler;

/**
 * @author shitianshu on 2017/10/2 上午9:55.
 */
@Service
public class SystemRoleProcessor {

    /** 日志 */
    private static final Logger LOG = LoggerFactory.getLogger(SystemRoleProcessor.class);

    @Resource
    private SystemRoleHandler systemRoleHandler;

    @Resource
    private SystemRoleUserMapperHandler systemRoleUserMapperHandler;

    /**
     * 通过系统用户ID获得对应的角色集合
     *
     * @param systemUserId
     * @return
     */
    public List<SystemRoleMo> fetchRoleByUserId(Integer systemUserId) {

        /** 从角色与用户映射表中获得指定用户对应的角色id集合 */
        List<SystemRoleUserMapperMo> systemRoleUserMapperList = systemRoleUserMapperHandler.fetchRoleIdInMapper(systemUserId);
        if (null == systemRoleUserMapperList || systemRoleUserMapperList.size() <= 0) {
            return null;
        }

        List<SystemRoleMo> systemRoleList = new ArrayList<>(systemRoleUserMapperList.size());

        for (SystemRoleUserMapperMo systemRoleUserMapper : systemRoleUserMapperList) {
            int roleId = systemRoleUserMapper.getRoleId();
            SystemRoleMo systemRoleMo = systemRoleHandler.fetchRoleById(roleId);
            if (null != systemRoleMo) {
                systemRoleList.add(systemRoleMo);
            }
        }
        return systemRoleList;
    }

    /**
     * 获得系统中所有的角色信息
     *
     * @return
     */
    public List<SystemRoleMo> fetchAllRole() {
        List<SystemRoleMo> systemRoleList = systemRoleHandler.fetchAllRole();
        return systemRoleList;
    }

}
