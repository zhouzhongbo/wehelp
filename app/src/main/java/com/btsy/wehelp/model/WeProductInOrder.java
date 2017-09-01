package com.btsy.wehelp.model;

import com.droi.sdk.core.DroiExpose;
import com.droi.sdk.core.DroiObject;
import com.droi.sdk.core.DroiReference;

/**
 * Created by zhouzhongbo on 2017/6/26.
 */

public class WeProductInOrder extends DroiObject {

    @DroiReference
    WeProduct product;    //商品信息

    @DroiExpose
    int amount;    //商品数量

    @DroiExpose
    boolean returns;    //是否退货

    @DroiExpose
    boolean  sendFlag;  //标记单独商品是否发货

}
