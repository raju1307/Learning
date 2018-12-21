package com.vodafoneidea.mva.test;

import com.appium.manager.ParallelThread;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Runner {


    @Test
    public void testApplication() throws Exception {
        ParallelThread parallelThread = new ParallelThread();

        List<String> tests = new ArrayList<>();
        tests.add("launchAppTest");

        parallelThread.runner("com.vodafoneidea.mva.test", tests);
    }
}
