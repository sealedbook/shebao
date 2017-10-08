/**
 * Copyright (c) 2017, TalkingData and/or its affiliates. All rights reserved.
 */
package net.vicp.sealedbook.processor.system;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.vicp.sealedbook.common.convert.SystemModuleConveter;
import net.vicp.sealedbook.dao.auto.model.SystemModuleMo;
import net.vicp.sealedbook.entity.dto.SystemMenuDTO;
import net.vicp.sealedbook.handler.system.SystemModuleHandler;

/**
 * @author shitianshu on 2017/10/2 下午5:13.
 */
@Service
public class SystemModuleProcessor {

    @Resource
    private SystemModuleHandler systemModuleHandler;

    public List<SystemMenuDTO> fetchRootModule() {

        List<SystemModuleMo> systemModuleList = systemModuleHandler.fetchRootModule();
        if (null == systemModuleList || systemModuleList.size() <= 0) {
            return null;
        }

        List<SystemMenuDTO> systemMenuDTOList = new ArrayList<>(systemModuleList.size());
        for (SystemModuleMo systemModule : systemModuleList) {
            if (null == systemModule) {
                continue;
            }
            SystemMenuDTO systemMenuDTO  = SystemModuleConveter.convertTo(systemModule);
            systemMenuDTOList.add(systemMenuDTO);
        }

        return systemMenuDTOList;
    }

    public List<SystemMenuDTO> fetchSubModule(int menuId) {
        if (menuId <= 0) {
            return null;
        }

        List<SystemModuleMo> systemModuleList = systemModuleHandler.fetchSubModule(menuId);
        if (null == systemModuleList || systemModuleList.size() <= 0) {
            return null;
        }

        List<SystemMenuDTO> systemMenuDTOList = new ArrayList<>(systemModuleList.size());
        for (SystemModuleMo systemModule : systemModuleList) {
            if (null == systemModule) {
                continue;
            }
            SystemMenuDTO systemMenuDTO  = SystemModuleConveter.convertTo(systemModule);
            systemMenuDTOList.add(systemMenuDTO);
        }

        return systemMenuDTOList;
    }
}
