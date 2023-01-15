package org.apache.ddlutils.test;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ddlutils.Platform;
import org.apache.ddlutils.PlatformFactory;
import org.junit.Before;

public class DdlUtilsBaseTest {

    public Platform platform;

    @Before
    public void setup(){
        BasicDataSource mysqlDataSource = new BasicDataSource();
        //mysqlDataSource.setda("ddlutils_test");
        mysqlDataSource.setUrl("jdbc:mysql://localhost:3306/ddlutils_test?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&serverTimezone=GMT%2B8");
        mysqlDataSource.setPassword("root");
        mysqlDataSource.setUsername("root");
        mysqlDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        platform = PlatformFactory.createNewPlatformInstance(mysqlDataSource);
    }
}
