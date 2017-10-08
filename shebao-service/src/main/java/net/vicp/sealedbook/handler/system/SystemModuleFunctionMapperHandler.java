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
import net.vicp.sealedbook.dao.auto.model.SystemModuleFunctionMapperMo;
import net.vicp.sealedbook.dao.dataprovider.system.SystemModuleFunctionMapperProvider;

/**
 * @author shitianshu on 2017/10/2 下午5:30.
 */
@Service
public class SystemModuleFunctionMapperHandler {

    private static final Logger LOG = LoggerFactory.getLogger(SystemModuleFunctionMapperHandler.class);

    @Resource
    private SystemModuleFunctionMapperProvider systemModuleFunctionMapperProvider;

    public List<SystemModuleFunctionMapperMo> fetchModuleFunctionByModuleId(int moduleId) {

        List<SystemModuleFunctionMapperMo> systemModuleFunctionMapperList = null;
        try {
            systemModuleFunctionMapperList = systemModuleFunctionMapperProvider.fetchModuleFunctionByModuleId(moduleId);
        } catch (DataBaseException e) {
            LogUtils.error(LOG, e, "fetch module function mapper error.");
        }
        return systemModuleFunctionMapperList;
    }
}
