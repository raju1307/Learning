package com.vodafoneidea.mva.test;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;


public class TestVer {

    static Logger log = Logger.getLogger(TestVer.class.getName());

    @Test
    public void FirstTest(){
        BasicConfigurator.configure();
        log.info("First Step");
        System.out.println("First Step - Done");
        log.info("Second Step");
        System.out.println("Second Step - Done");
        log.info("Third Step");
        System.out.println("Third Step - Done");
        log.info("Fourth Step");
        System.out.println("Fourth Step - Done");
    }

}
