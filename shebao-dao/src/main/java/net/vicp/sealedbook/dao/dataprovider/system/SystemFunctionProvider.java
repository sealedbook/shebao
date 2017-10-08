/**
 * Copyright (c) 2017, TalkingData and/or its affiliates. All rights reserved.
 */
package net.vicp.sealedbook.dao.dataprovider.system;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.vicp.sealedbook.common.exception.DataBaseException;
import net.vicp.sealedbook.dao.auto.mapper.SystemFunctionMapper;
import net.vicp.sealedbook.dao.auto.model.SystemFunctionMo;

/**
 * @author shitianshu on 2017/10/2 下午4:41.
 */
@Service
public class SystemFunctionProvider {

    @Resource
    private SystemFunctionMapper systemFunctionMapper;


    public SystemFunctionMo fetchFunctionById(int functionId) throws DataBaseException {

        SystemFunctionMo systemFunction = null;
        try {
            systemFunction = systemFunctionMapper.selectByPrimaryKey(functionId);
            return systemFunction;
        } catch(Throwable e) {
            throw new DataBaseException(e.getMessage());
        }
    }
}
