package com.btsy.wehelp.database.dao;

import java.util.List;

/**
 * Created by zzb on 2017/11/24.
 */

public class ShopProductInOrder extends ShopProduct{

    int amount;    //商品数量

    boolean returns;    //是否退货
    /*
    注意，此属性用于订单分包发货操作
     */
    boolean  sendFlag;  //标记单独商品是否发货

    String logisticsNumber; //快递单号(图像识别出来)

    //    List<DroiFile> logistics;    //快递单pic
    List<String> logistics;    //快递单pic
}
