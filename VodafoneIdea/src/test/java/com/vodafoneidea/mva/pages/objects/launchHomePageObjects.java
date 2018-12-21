package com.vodafoneidea.mva.pages.objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class launchHomePageObjects {


    @AndroidFindBy(id = "com.android.packageinstaller:id/desc_container")
    public MobileElement descriptionContainer;

    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    public MobileElement allowPermissionButton;


}
