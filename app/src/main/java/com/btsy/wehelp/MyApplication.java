package com.btsy.wehelp;

import android.app.Application;
import android.content.ComponentCallbacks;

import com.btsy.wehelp.model.WeCustomer;
import com.btsy.wehelp.model.WeOrder;
import com.btsy.wehelp.model.WeProduct;
import com.btsy.wehelp.model.WeProductInOrder;
import com.btsy.wehelp.model.WeStock;
import com.btsy.wehelp.model.WeUser;
import com.btsy.wehelp.model.WeVipInfo;
import com.droi.sdk.core.Core;
import com.droi.sdk.core.DroiObject;
import com.droi.sdk.core.DroiPermission;

/**
 * Created by zhouzhongbo on 2017/6/26.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Core.initialize(this);

        DroiObject.registerCustomClass( WeUser.class );
        DroiObject.registerCustomClass( WeCustomer.class );
        DroiObject.registerCustomClass( WeOrder.class );
        DroiObject.registerCustomClass( WeProduct.class );
        DroiObject.registerCustomClass( WeProductInOrder.class );
        DroiObject.registerCustomClass( WeStock.class );
        DroiObject.registerCustomClass( WeVipInfo.class );
        DroiPermission permission = DroiPermission.getDefaultPermission();
        if(permission == null){
            permission = new DroiPermission();
        }
        permission.setPublicReadPermission(true);
        permission.setPublicWritePermission(true);
        DroiPermission.setDefaultPermission(permission);
    }




    @Override
    public void registerComponentCallbacks(ComponentCallbacks callback) {
        super.registerComponentCallbacks(callback);
    }


}
