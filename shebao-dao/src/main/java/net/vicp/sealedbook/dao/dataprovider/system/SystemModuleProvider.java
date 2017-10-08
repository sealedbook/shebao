/**
 * Copyright (c) 2017, TalkingData and/or its affiliates. All rights reserved.
 */
package net.vicp.sealedbook.dao.dataprovider.system;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.vicp.sealedbook.common.exception.DataBaseException;
import net.vicp.sealedbook.dao.auto.criteria.SystemModuleExample;
import net.vicp.sealedbook.dao.auto.mapper.SystemModuleMapper;
import net.vicp.sealedbook.dao.auto.model.SystemModuleMo;

/**
 * @author shitianshu on 2017/10/2 下午5:02.
 */
@Service
public class SystemModuleProvider {

    @Resource
    private SystemModuleMapper systemModuleMapper;

    public List<SystemModuleMo> fetchSubModule(int parentModuleId) throws DataBaseException {
        SystemModuleExample systemModuleExample = new SystemModuleExample();
        SystemModuleExample.Criteria criteria = systemModuleExample.createCriteria();
        criteria.andParentIdEqualTo(parentModuleId);

        List<SystemModuleMo> systemModuleMoList = null;
        try {
            systemModuleMoList = systemModuleMapper.selectByExample(systemModuleExample);
            return systemModuleMoList;
        } catch (Throwable e) {
            throw new DataBaseException(e.getMessage());
        }
    }
}
