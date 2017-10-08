/**
 * Copyright (c) 2017, TalkingData and/or its affiliates. All rights reserved.
 */
package net.vicp.sealedbook.support.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import net.vicp.sealedbook.processor.system.SystemMenuProcessor;
import net.vicp.sealedbook.support.spring.SpringContextHolder;

/**
 * @author shitianshu on 2017/10/2 下午4:11.
 */
public class SystemInitListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        SystemMenuProcessor systemMenuProcessor = SpringContextHolder.getBean("systemMenuProcessor");
        //init system menus
        systemMenuProcessor.initMenuWithRole();

//        ResourceService resourceService = (ResourceService)WebApplicationContextUtil.getBean("resourceService");
//        //init global resource
//        resourceService.initGlobalResource();
//
//        OrganizeService organizeService =(OrganizeService)WebApplicationContextUtil.getBean("organizeService");
//        Iterable<OrganizeEntity> allOrganize = organizeService.getAllOrganizeEntity();
//        OrganizeCacheUtil organizeCacheUtil = OrganizeCacheUtil.getInstance();
//        Iterator<OrganizeEntity> iterator = allOrganize.iterator();
//        int count = 0;
//        while(iterator.hasNext()) {
//            OrganizeEntity organizeEntity = iterator.next();
//            organizeCacheUtil.setOrganize(organizeEntity.getId(), organizeEntity);
//            ++count;
//        }
//        logger.info("======Organize缓存,总数:" + count + ".");

    }

}
