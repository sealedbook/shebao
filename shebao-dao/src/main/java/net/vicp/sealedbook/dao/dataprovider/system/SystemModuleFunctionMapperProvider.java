/**
 * Copyright (c) 2017, TalkingData and/or its affiliates. All rights reserved.
 */
package net.vicp.sealedbook.dao.dataprovider.system;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.vicp.sealedbook.common.exception.DataBaseException;
import net.vicp.sealedbook.dao.auto.criteria.SystemModuleFunctionMapperExample;
import net.vicp.sealedbook.dao.auto.mapper.SystemModuleFunctionMapperMapper;
import net.vicp.sealedbook.dao.auto.model.SystemModuleFunctionMapperMo;

/**
 * @author shitianshu on 2017/10/2 下午5:32.
 */
@Service
public class SystemModuleFunctionMapperProvider {

    @Resource
    private SystemModuleFunctionMapperMapper systemModuleFunctionMapperMapper;

    public List<SystemModuleFunctionMapperMo> fetchModuleFunctionByModuleId(int moduleId) throws DataBaseException {

        SystemModuleFunctionMapperExample systemModuleFunctionMapperExample = new SystemModuleFunctionMapperExample();
        SystemModuleFunctionMapperExample.Criteria criteria = systemModuleFunctionMapperExample.createCriteria();
        criteria.andModuleIdEqualTo(moduleId);

        List<SystemModuleFunctionMapperMo> systemModuleFunctionMapperList = null;
        try {
            systemModuleFunctionMapperList = systemModuleFunctionMapperMapper.selectByExample(systemModuleFunctionMapperExample);
            return systemModuleFunctionMapperList;
        } catch (Throwable e) {
            throw new DataBaseException(e.getMessage());
        }
    }
}
