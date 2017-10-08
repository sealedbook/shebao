/**
 * Copyright (c) 2017, TalkingData and/or its affiliates. All rights reserved.
 */
package net.vicp.sealedbook.dao.dataprovider.system;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import net.vicp.sealedbook.common.exception.DataBaseException;
import net.vicp.sealedbook.dao.auto.criteria.SystemRoleUserMapperExample;
import net.vicp.sealedbook.dao.auto.mapper.SystemRoleUserMapperMapper;
import net.vicp.sealedbook.dao.auto.model.SystemRoleUserMapperMo;

/**
 * @author shitianshu on 2017/10/2 上午10:07.
 */
@Service
public class SystemRoleUserMapperProvider {

    private static final Logger LOG = LoggerFactory.getLogger(SystemRoleUserMapperProvider.class);

    @Resource
    private SystemRoleUserMapperMapper systemRoleUserMapperMapper;

    public List<SystemRoleUserMapperMo> fetchRoleIdInMapper(Integer systemUserId) throws DataBaseException {

        SystemRoleUserMapperExample systemRoleUserMapperExample = new SystemRoleUserMapperExample();
        SystemRoleUserMapperExample.Criteria criteria = systemRoleUserMapperExample.createCriteria();
        criteria.andUserIdEqualTo(systemUserId);

        try {
            return systemRoleUserMapperMapper.selectByExample(systemRoleUserMapperExample);
        } catch (Throwable e) {
            throw new DataBaseException(e.getMessage());
        }
    }
}
