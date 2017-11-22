package com.btsy.wehelp;

import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;

import com.btsy.wehelp.database.dao.WeCustomer;
import com.btsy.wehelp.database.dao.WeOrder;
import com.btsy.wehelp.database.dao.WeProduct;
import com.btsy.wehelp.database.dao.WeProductInOrder;
import com.btsy.wehelp.database.dao.WeStock;
import com.btsy.wehelp.database.dao.WeUser;
import com.btsy.wehelp.database.dao.WeVipInfo;
import com.droi.sdk.core.Core;
import com.droi.sdk.core.DroiObject;
import com.droi.sdk.core.DroiPermission;

/**
 * Created by zhouzhongbo on 2017/6/26.
 */

public class BaseApplication extends Application {


    private static BaseApplication mApplication;

    /**
     * 获取Context
     * @return 返回Context的对象
     */
    public static Context getContext(){
        return mApplication.getApplicationContext();
    }

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
