package com.btsy.wehelp.database.dao;

import com.droi.sdk.core.DroiExpose;
import com.droi.sdk.core.DroiObject;

/**
 * Created by zhouzhongbo on 2017/9/1.
 */

public class WeVipInfo extends DroiObject {

    @DroiExpose
    int level;   //vip分类登记;

    @DroiExpose
    long data;   //vip有效期;


}
