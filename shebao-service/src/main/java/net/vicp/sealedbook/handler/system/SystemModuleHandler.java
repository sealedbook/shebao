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
import net.vicp.sealedbook.dao.auto.model.SystemModuleMo;
import net.vicp.sealedbook.dao.dataprovider.system.SystemModuleProvider;

/**
 * @author shitianshu on 2017/10/2 下午5:01.
 */
@Service
public class SystemModuleHandler {

    /** 日志 */
    private static final Logger LOG = LoggerFactory.getLogger(SystemModuleHandler.class);

    @Resource
    private SystemModuleProvider systemModuleProvider;

    public List<SystemModuleMo> fetchRootModule() {
        List<SystemModuleMo> systemModuleList = null;
        try {
            systemModuleList = systemModuleProvider.fetchSubModule(-1);
        } catch (DataBaseException e) {
            LogUtils.error(LOG, e, "fetch root module error");
        }
        return systemModuleList;
    }

    public List<SystemModuleMo> fetchSubModule(int parentModuleId) {
        List<SystemModuleMo> systemModuleList = null;
        if (parentModuleId <= 0) {
            try {
                systemModuleList = systemModuleProvider.fetchSubModule(-1);
            } catch (DataBaseException e) {
                LogUtils.error(LOG, e, "fetch root module error");
            }
        } else {
            try {
                systemModuleList = systemModuleProvider.fetchSubModule(parentModuleId);
            } catch (DataBaseException e) {
                LogUtils.error(LOG, e, "fetch root module error");
            }
        }
        return systemModuleList;
    }

}
