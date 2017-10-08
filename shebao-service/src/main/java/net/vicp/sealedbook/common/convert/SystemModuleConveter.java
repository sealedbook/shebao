/**
 * Copyright (c) 2017, TalkingData and/or its affiliates. All rights reserved.
 */
package net.vicp.sealedbook.common.convert;

import net.vicp.sealedbook.dao.auto.model.SystemModuleMo;
import net.vicp.sealedbook.entity.dto.SystemMenuDTO;

/**
 * @author shitianshu on 2017/10/2 下午5:18.
 */
public final class SystemModuleConveter {

    public static SystemMenuDTO convertTo(SystemModuleMo systemModule) {
        if (null == systemModule) {
            return null;
        }

        SystemMenuDTO systemMenuDTO  = new SystemMenuDTO();
        systemMenuDTO.setId(systemModule.getId());
        systemMenuDTO.setIcon(systemModule.getIcon());
        systemMenuDTO.setName(systemModule.getModuleName());
        systemMenuDTO.setOrder(systemModule.getOrdered());
        systemMenuDTO.setUrl(systemModule.getEntryUrl());
        return systemMenuDTO;
    }

}
