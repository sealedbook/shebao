/**
 * Copyright (c) 2017, TalkingData and/or its affiliates. All rights reserved.
 */
package net.vicp.sealedbook.processor.system;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import net.vicp.sealedbook.common.utils.LogUtils;
import net.vicp.sealedbook.dao.auto.model.SystemFunctionMo;
import net.vicp.sealedbook.dao.auto.model.SystemRoleMo;
import net.vicp.sealedbook.entity.dto.SystemMenuDTO;
import net.vicp.sealedbook.handler.system.SystemRoleHandler;

/**
 * @author shitianshu on 2017/10/2 上午11:20.
 */
@Service
public class SystemMenuProcessor {

    /**
     * 日志
     */
    private static final Logger LOG = LoggerFactory.getLogger(SystemMenuProcessor.class);

    @Resource
    private SystemRoleHandler systemRoleHandler;

    @Resource
    private SystemFunctionProcessor systemFunctionProcessor;

    @Resource
    private SystemRoleProcessor systemRoleProcessor;

    @Resource
    private SystemModuleProcessor systemModuleProcessor;

    private Map<String, List<SystemMenuDTO>> menuCache = new ConcurrentHashMap<>();

    private Map<String, List<SystemMenuDTO>> systemMenuCache = new ConcurrentHashMap<>();

    /**
     * 初始化系统菜单(不分角色)
     */
    private void initSystemMenu() {
        systemMenuCache.clear();
        getSystemMenu();
    }

    public void initMenuWithRole() {
        initSystemMenu();
        menuCache.clear();
        List<SystemRoleMo> roleList = systemRoleHandler.fetchAllRole();
        LOG.info("fetch all role from system.", "role number", roleList.size());
        for (SystemRoleMo role : roleList) {
            initRoleMenu(role);
            LogUtils.info(LOG, "init role menu", "role name", role.getRoleName());
        }
    }

    /**
     * 初始化角色对应的菜单
     */
    private List<SystemMenuDTO> initRoleMenu(SystemRoleMo role) {
        List<SystemMenuDTO> menuList = buildRoleMenu(role);
        String key = String.valueOf(role.getId());
        menuCache.put(key, menuList);
        return menuList;
    }

    private List<SystemMenuDTO> buildRoleMenu(SystemRoleMo role) {
        List<SystemMenuDTO> systemMenuCollection = getSystemMenu();
        List<SystemMenuDTO> userMenuCollection = new ArrayList<SystemMenuDTO>();
        for (SystemMenuDTO systemMenu : systemMenuCollection) {
            SystemMenuDTO menu = createUserMenu(role, systemMenu);
            if (null != menu) {
                userMenuCollection.add(menu);
            }
        }
        return userMenuCollection;
    }

    private SystemMenuDTO createUserMenu(SystemRoleMo role, SystemMenuDTO systemMenu) {
        SystemMenuDTO subSystemMenu = new SystemMenuDTO(systemMenu);
        boolean hasSubMenu = false;
        if (systemMenu.getSubSystemMenuSize() > 0) {
            List<SystemMenuDTO> systemMenuCollection = systemMenu.getSubSystemMenu();
            for (SystemMenuDTO sMenu : systemMenuCollection) {
                SystemMenuDTO subMenu = createUserMenu(role, sMenu);
                if (null != subMenu) {
                    subSystemMenu.getSubSystemMenu().add(subMenu);
                    hasSubMenu = true;
                }
            }
            if (hasSubMenu) {
                return subSystemMenu;
            }
            return null;
        }
        if (roleContainsSystemFunction(role, systemMenu)) {
            return systemMenu;
        } else {
            return null;
        }
    }

    private boolean roleContainsSystemFunction(SystemRoleMo role, SystemMenuDTO subSystemMenu) {

        List<SystemFunctionMo> systemFunctionList = systemFunctionProcessor.fetchSystemFunctionByRoleId(role.getId());
        if (null == systemFunctionList || systemFunctionList.isEmpty()) {
            return false;
        }

        if (null == subSystemMenu.getSubFunction()) {
            return false;
        }

        for (SystemFunctionMo systemFunction : subSystemMenu.getSubFunction()) {
            for (SystemFunctionMo roleFunction : systemFunctionList) {
                if (roleFunction.equals(systemFunction)) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<SystemMenuDTO> getMenu(int userId) {

        List<SystemRoleMo> userRoleList = systemRoleProcessor.fetchRoleByUserId(userId);
        List<SystemMenuDTO> userMenu = new ArrayList<SystemMenuDTO>();
        for (SystemRoleMo role : userRoleList) {
            List<SystemMenuDTO> roleSystemMenu = getMenuByRole(role);
            if (null != roleSystemMenu) {
                userMenu.addAll(roleSystemMenu);
            }
        }
        return processUserMenu(userMenu);
    }

    private List<SystemMenuDTO> processUserMenu(List<SystemMenuDTO> userMenus) {
        List<SystemMenuDTO> userMenu = new ArrayList<SystemMenuDTO>();
        for (SystemMenuDTO roleMenu : userMenus) {
            if (!userMenu.contains(roleMenu)) {
                userMenu.add(roleMenu);
            } else {
                SystemMenuDTO containsMenu = userMenu.get(userMenu.indexOf(roleMenu));
                List<SystemMenuDTO> roleSubMenuList = roleMenu.getSubSystemMenu();
                List<SystemMenuDTO> containsSubMenuList = containsMenu.getSubSystemMenu();
                for (SystemMenuDTO roleSubMenu : roleSubMenuList) {
                    if (!containsSubMenuList.contains(roleSubMenu)) {
                        containsSubMenuList.add(roleSubMenu);
                    }
                }
            }
        }
        menuSort(userMenu);
        return userMenu;
    }

    /**
     * 按照系统模块的order字段排序
     */
    private void menuSort(List<SystemMenuDTO> menus) {
        Collections.sort(menus);
        for (SystemMenuDTO menu : menus) {
            if (null != menu.getSubSystemMenu() && !menu.getSubSystemMenu().isEmpty()) {
                menuSort(menu.getSubSystemMenu());
            }
        }
    }

    private List<SystemMenuDTO> getMenuByRole(SystemRoleMo role) {
        String key = String.valueOf(role.getId());
        List<SystemMenuDTO> systemMenuDTOList = menuCache.get(key);
        if (null == systemMenuDTOList) {
            return initRoleMenu(role);
        } else {
            return systemMenuDTOList;
        }
    }

    public List<SystemMenuDTO> getSystemMenu() {
        List<SystemMenuDTO> systemMenuElement = systemMenuCache.get("SYSTEM_MENU");
        if (null == systemMenuElement) {
            List<SystemMenuDTO> systemMenu = createSystemMenu(0);
            menuSort(systemMenu);
            systemMenuCache.put("SYSTEM_MENU", systemMenu);
            return systemMenu;
        } else {
            return systemMenuElement;
        }
    }

    private List<SystemMenuDTO> createSystemMenu(int menuId) {
        if (menuId <= 0) {
            List<SystemMenuDTO> firstMenuList = systemModuleProcessor.fetchRootModule();
            if (null == firstMenuList) {
                return null;
            }
            for (SystemMenuDTO menu : firstMenuList) {
                List<SystemFunctionMo> systemFunctionList = systemFunctionProcessor.fetchSystemFunctionByModuleId(menu.getId());
                menu.setSubFunction(systemFunctionList);
                menu.setSubSystemMenu(createSystemMenu(menu.getId()));
            }
            return firstMenuList;
        } else {
            List<SystemMenuDTO> menuList = systemModuleProcessor.fetchSubModule(menuId);
            if (null == menuList) {
                return null;
            }
            for (SystemMenuDTO menu : menuList) {
                List<SystemFunctionMo> systemFunctionList = systemFunctionProcessor.fetchSystemFunctionByModuleId(menu.getId());
                menu.setSubFunction(systemFunctionList);
                menu.setSubSystemMenu(createSystemMenu(menu.getId()));
            }
            return menuList;
        }
    }

}
