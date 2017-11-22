package com.btsy.wehelp.database.dao;

import com.droi.sdk.core.DroiExpose;
import com.droi.sdk.core.DroiFile;
import com.droi.sdk.core.DroiObject;
import com.droi.sdk.core.DroiReference;

import java.util.List;

/**
 * Created by zhouzhongbo on 2017/6/26.
 */

//订单描述
public class WeOrder extends DroiObject {

    @DroiExpose
    List<WeProductInOrder> productList;    //所有商品的信息

    @DroiReference
    WeCustomer customer;    //订单客户

    @DroiReference
    WeCustomer sender;   //代发人(同样是客户)

    @DroiExpose
    long orderData;     //订单日期

    @DroiExpose
    List<DroiFile> logistics;   //快递、物流 单拍照  //可能存在分包发送的情况

    @DroiExpose
    List<String> logisticsNumber; //快递单号(图像识别出来)
}


