package com.btsy.wehelp.model;

import com.droi.sdk.core.DroiExpose;
import com.droi.sdk.core.DroiObject;
import com.droi.sdk.core.DroiReference;

/**
 * Created by zhouzhongbo on 2017/6/26.
 */

public class WeProductInOrder extends DroiObject {

    @DroiReference
    WeBaseProduct product;    //商品信息

    @DroiExpose
    int amount;    //商品数量

    @DroiExpose
    String orderStatus;    //订单状态
}
