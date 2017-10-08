/**
 * Copyright (c) 2017, TalkingData and/or its affiliates. All rights reserved.
 */
package net.vicp.sealedbook.handler.system;


import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import net.vicp.sealedbook.common.exception.DataBaseException;
import net.vicp.sealedbook.common.utils.LogUtils;
import net.vicp.sealedbook.dao.auto.model.SystemFunctionMo;
import net.vicp.sealedbook.dao.dataprovider.system.SystemFunctionProvider;


/**
 * @author shitianshu on 2017/10/2 下午4:23.
 */
@Service
public class SystemFunctionHandler {

    /** 日志 */
    private static final Logger LOG = LoggerFactory.getLogger(SystemFunctionHandler.class);

    @Resource
    private SystemFunctionProvider systemFunctionProvider;

    public SystemFunctionMo fetchFunctionById(int functionId) {
        SystemFunctionMo systemFunction = null;
        try {
            systemFunction = systemFunctionProvider.fetchFunctionById(functionId);
        } catch (DataBaseException e) {
            LogUtils.error(LOG, e, "fetch function by id error.", "functionId", functionId);
        }
        return systemFunction;
    }
}
