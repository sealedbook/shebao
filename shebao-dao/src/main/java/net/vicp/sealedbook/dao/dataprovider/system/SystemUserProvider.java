/**
 * Copyright (c) 2017, TalkingData and/or its affiliates. All rights reserved.
 */
package net.vicp.sealedbook.dao.dataprovider.system;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import net.vicp.sealedbook.common.exception.DataBaseException;
import net.vicp.sealedbook.dao.auto.criteria.SystemUserExample;
import net.vicp.sealedbook.dao.auto.mapper.SystemUserMapper;
import net.vicp.sealedbook.dao.auto.model.SystemUserMo;

/**
 * 系统用户数据库服务
 *
 * @author shitianshu on 2017/10/2 上午9:14.
 */
@Service
public class SystemUserProvider {

    private static final Logger LOG = LoggerFactory.getLogger(SystemUserProvider.class);

    @Resource
    private SystemUserMapper systemUserMapper;

    /**
     * 根据登录账号，获得系统用户
     *
     * @param account
     * @return
     * @throws DataBaseException
     */
    public List<SystemUserMo> fetchUserByAccount(String account) throws DataBaseException {
        if (!StringUtils.hasText(account)) {
            return null;
        }

        SystemUserExample systemUserExample = new SystemUserExample();
        SystemUserExample.Criteria criteria = systemUserExample.createCriteria();
        criteria.andAccountEqualTo(account);

        try {
            List<SystemUserMo> systemUserMoList = systemUserMapper.selectByExample(systemUserExample);
            return systemUserMoList;
        } catch (Throwable e) {
            throw new DataBaseException(e.getMessage());
        }
    }
}
