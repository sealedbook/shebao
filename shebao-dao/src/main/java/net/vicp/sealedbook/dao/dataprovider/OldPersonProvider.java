/**
 * Copyright (c) 2017, TalkingData and/or its affiliates. All rights reserved.
 */
package net.vicp.sealedbook.dao.dataprovider;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import net.vicp.sealedbook.common.exception.DataBaseException;
import net.vicp.sealedbook.common.exception.DuplicateDataException;
import net.vicp.sealedbook.dao.auto.mapper.OldPersonMapper;
import net.vicp.sealedbook.dao.auto.model.OldPersonMo;

/**
 * @author shitianshu on 2017/9/24 下午7:50.
 */
@Service
public class OldPersonProvider {

    private static final Logger LOG = LoggerFactory.getLogger(OldPersonProvider.class);

    @Resource
    private OldPersonMapper oldPersonMapper;

    public void createOldPerson(OldPersonMo oldPerson) throws DataBaseException {
        if (null == oldPerson) {
            throw new NullPointerException("old person is null");
        }
        try {
            oldPersonMapper.insert(oldPerson);
        } catch(DuplicateKeyException e) {
            throw new DuplicateDataException(e.getMessage());
        } catch(Throwable e) {
            throw new DataBaseException(e.getMessage());
        }
    }

}
