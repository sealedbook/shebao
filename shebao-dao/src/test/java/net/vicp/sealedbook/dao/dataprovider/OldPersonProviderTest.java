package net.vicp.sealedbook.dao.dataprovider;

import java.util.UUID;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.vicp.sealedbook.dao.auto.model.OldPersonMo;
import net.vicp.sealedbook.enums.OldPersonTypeEnum;

/**
* OldPersonProvider Tester.
*
* @author shitianshu on 09/24/2017.
*
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:/spring-junit.xml"})
public class OldPersonProviderTest {

    @Resource
    private OldPersonProvider oldPersonProvider;

    @Before
    public void before() throws Throwable {
        
    }

    @After
    public void after() throws Throwable {
        
    }

    /**
    *
    * Method: createOldPerson(OldPersonMo oldPerson)
    *
    */
    @Test
    @Rollback(true)
    public void testCreateOldPerson() throws Throwable {
        OldPersonMo oldPerson = new OldPersonMo();
        oldPerson.setName("test");
        oldPerson.setNameSpell("nad");
        oldPerson.setIdCard("idcard");
        oldPerson.setAreaId("areaid");
        oldPerson.setType(OldPersonTypeEnum.LOCAL_PERSON);

        oldPersonProvider.createOldPerson(oldPerson);
    }



    /** Log util */
    private static final Logger LOG = LoggerFactory.getLogger(OldPersonProviderTest.class);
} 
