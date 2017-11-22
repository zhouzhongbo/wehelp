package com.btsy.wehelp.database.dao;

import com.droi.sdk.core.DroiExpose;
import com.droi.sdk.core.DroiObject;
import com.droi.sdk.core.DroiReference;

/**
 * Created by zhouzhongbo on 2017/6/26.
 */

public class WeStock extends DroiObject {

    @DroiReference
    WeProduct product;

    @DroiExpose
    int amount;
}
