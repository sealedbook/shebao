/**
 * Copyright (c) 2017, TalkingData and/or its affiliates. All rights reserved.
 */
package net.vicp.sealedbook.dao.dataprovider.system;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.vicp.sealedbook.common.exception.DataBaseException;
import net.vicp.sealedbook.dao.auto.criteria.SystemRoleFunctionMapperExample;
import net.vicp.sealedbook.dao.auto.mapper.SystemRoleFunctionMapperMapper;
import net.vicp.sealedbook.dao.auto.model.SystemRoleFunctionMapperMo;

/**
 * @author shitianshu on 2017/10/2 下午4:35.
 */
@Service
public class SystemRoleFunctionMapperProvider {

    @Resource
    private SystemRoleFunctionMapperMapper systemRoleFunctionMapperMapper;

    public List<SystemRoleFunctionMapperMo> fetchRoleFunctionByRoleId(int roleId) throws DataBaseException {

        SystemRoleFunctionMapperExample systemRoleFunctionMapperExample = new SystemRoleFunctionMapperExample();
        SystemRoleFunctionMapperExample .Criteria criteria = systemRoleFunctionMapperExample.createCriteria();
        criteria.andRoleIdEqualTo(roleId);

        try {
            return systemRoleFunctionMapperMapper.selectByExample(systemRoleFunctionMapperExample);
        } catch (Throwable e) {
            throw new DataBaseException(e.getMessage());
        }
    }
}
