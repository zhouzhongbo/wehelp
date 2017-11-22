package com.btsy.wehelp.database.dao;

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

    /*
    注意，此属性用于订单分包发货操作
     */
    @DroiExpose
    boolean  sendFlag;  //标记单独商品是否发货

    @DroiExpose
    String logisticsNumber; //快递单号(图像识别出来)
}
