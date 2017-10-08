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

import net.vicp.sealedbook.dao.auto.model.SystemFunctionMo;
import net.vicp.sealedbook.dao.auto.model.SystemModuleFunctionMapperMo;
import net.vicp.sealedbook.dao.auto.model.SystemRoleFunctionMapperMo;
import net.vicp.sealedbook.handler.system.SystemFunctionHandler;
import net.vicp.sealedbook.handler.system.SystemModuleFunctionMapperHandler;
import net.vicp.sealedbook.handler.system.SystemRoleFunctionMapperHandler;

/**
 * @author shitianshu on 2017/10/2 下午4:29.
 */
@Service
public class SystemFunctionProcessor {

    /**
     * 日志
     */
    private static final Logger LOG = LoggerFactory.getLogger(SystemFunctionProcessor.class);

    @Resource
    private SystemFunctionHandler systemFunctionHandler;
    @Resource
    private SystemModuleFunctionMapperHandler systemModuleFunctionMapperHandler;
    @Resource
    private SystemRoleFunctionMapperHandler systemRoleFunctionMapperHandler;

    public List<SystemFunctionMo> fetchSystemFunctionByRoleId(int roleId) {

        /** 先通过角色id查到配置对应的function info */
        List<SystemRoleFunctionMapperMo> systemRoleFunctionMapperList = systemRoleFunctionMapperHandler.fetchRoleFunctionByRoleId(roleId);
        if (null == systemRoleFunctionMapperList) {
            return null;
        }

        List<SystemFunctionMo> systemFunctionList = new ArrayList<>(systemRoleFunctionMapperList.size());

        for (SystemRoleFunctionMapperMo systemRoleFunctionMapper : systemRoleFunctionMapperList) {
            int functionId = systemRoleFunctionMapper.getFunctionId();
            SystemFunctionMo systemFunction = systemFunctionHandler.fetchFunctionById(functionId);
            if (null != systemFunction) {
                systemFunctionList.add(systemFunction);
            }
        }
        return systemFunctionList;
    }

    public List<SystemFunctionMo> fetchSystemFunctionByModuleId(int moduleId) {

        List<SystemModuleFunctionMapperMo> systemModuleFunctionMapperList = null;
        systemModuleFunctionMapperList = systemModuleFunctionMapperHandler.fetchModuleFunctionByModuleId(moduleId);
        if (null == systemModuleFunctionMapperList || systemModuleFunctionMapperList.isEmpty()) {
            return null;
        }
        List<SystemFunctionMo> systemFunctionList = new ArrayList<>(systemModuleFunctionMapperList.size());
        for (SystemModuleFunctionMapperMo systemModuleFunctionMapper : systemModuleFunctionMapperList) {

            SystemFunctionMo systemFunction = systemFunctionHandler.fetchFunctionById(systemModuleFunctionMapper.getFunctionId());
            if (null != systemFunction) {
                systemFunctionList.add(systemFunction);
            }

        }
        return systemFunctionList;
    }

}
