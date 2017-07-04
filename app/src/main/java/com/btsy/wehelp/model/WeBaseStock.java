package com.btsy.wehelp.model;

import com.droi.sdk.core.DroiExpose;
import com.droi.sdk.core.DroiObject;
import com.droi.sdk.core.DroiReference;

/**
 * Created by zhouzhongbo on 2017/6/26.
 */

public class WeBaseStock extends DroiObject {

    @DroiReference
    WeBaseProduct product;

    @DroiExpose
    int amount;
}
