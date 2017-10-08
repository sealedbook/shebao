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
import net.vicp.sealedbook.dao.auto.criteria.SystemRoleExample;
import net.vicp.sealedbook.dao.auto.mapper.SystemRoleMapper;
import net.vicp.sealedbook.dao.auto.model.SystemRoleMo;

/**
 * @author shitianshu on 2017/10/2 上午10:15.
 */
@Service
public class SystemRoleProvider {

    private static final Logger LOG = LoggerFactory.getLogger(SystemRoleProvider.class);

    @Resource
    private SystemRoleMapper systemRoleMapper;

    /**
     * 根据角色id获得角色信息
     *
     * @param roleId
     * @return
     * @throws DataBaseException
     */
    public SystemRoleMo fetchRoleById(int roleId) throws DataBaseException {
        try {
            return systemRoleMapper.selectByPrimaryKey(roleId);
        } catch (Throwable e) {
            throw new DataBaseException(e.getMessage());
        }
    }

    /**
     * 获得所有角色
     *
     * @return
     * @throws DataBaseException
     */
    public List<SystemRoleMo> fetchAll() throws DataBaseException {

        SystemRoleExample systemRoleExample = new SystemRoleExample();
        SystemRoleExample.Criteria criteria = systemRoleExample.createCriteria();

        try {
            return systemRoleMapper.selectByExample(systemRoleExample);
        } catch (Throwable e) {
            throw new DataBaseException(e.getMessage());
        }
    }
}
