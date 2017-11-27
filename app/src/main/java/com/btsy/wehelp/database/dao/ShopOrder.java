package com.btsy.wehelp.database.dao;

import java.util.List;

/**
 * Created by zzb on 2017/11/24.
 */

public class ShopOrder {

    List<ShopProductInOrder> productList;    //所有商品的信息

    ShopCustomer customer;    //订单客户

    ShopCustomer sender;   //代发人(同样是客户)

    long orderData;     //订单日期

//    List<DroiFile> logistics;   //快递、物流 单拍照  //可能存在分包发送的情况
    String logistics;


//    List<String> logisticsNumber; //快递单号(图像识别出来)
    String logisticsNumber;
}
