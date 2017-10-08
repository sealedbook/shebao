/**
 * Copyright (c) 2017, TalkingData and/or its affiliates. All rights reserved.
 */
package net.vicp.sealedbook.controller.system;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.vicp.sealedbook.dao.auto.model.SystemRoleMo;
import net.vicp.sealedbook.entity.dto.SystemRoleDTO;
import net.vicp.sealedbook.processor.system.SystemRoleProcessor;

/**
 * @author shitianshu on 2017/10/8 上午10:03.
 */
@Controller
public class SystemRoleController {

    private static final Logger LOG = LoggerFactory.getLogger(SystemRoleController.class);

    @Resource
    private SystemRoleProcessor systemRoleProcessor;

    @RequestMapping("/system/role/all")
    @ResponseBody
    public List<SystemRoleDTO> allRole() {
        List<SystemRoleMo> systemRoleMoList = systemRoleProcessor.fetchAllRole();

        List<SystemRoleDTO> systemRoleDTOList = new ArrayList<>();
        if (null == systemRoleMoList) {
            return systemRoleDTOList;
        }

        for (SystemRoleMo systemRole : systemRoleMoList) {
            SystemRoleDTO systemRoleDTO = new SystemRoleDTO();
            systemRoleDTO.setId(systemRole.getId());
            systemRoleDTO.setText(systemRole.getRoleName());
            systemRoleDTOList.add(systemRoleDTO);
        }
        return systemRoleDTOList;
    }

}
