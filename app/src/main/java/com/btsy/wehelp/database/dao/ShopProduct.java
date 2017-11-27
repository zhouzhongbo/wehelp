package com.btsy.wehelp.database.dao;

import java.util.List;
import java.util.Map;

/**
 * Created by zzb on 2017/11/24.
 */

public class ShopProduct {
    String productName;    //商品名称

    float priceOut;    //商品售价

    float priceIn;    //商品进价

    boolean isValid;    //商品信息是否可用(信息废弃)

//    List<DroiFile> headerImage;    //商品图片
    List<String> headerImage;    //商品图片

//    List<DroiFile> imagelList;    //商品描述图列表
    List<String> imagelList;    //商品描述图列表

    String description;    //商品描述

    String note;     //商品备注

    ShopBrand brand;

    Map<String,String> sku;   //产品型号等sku

    List<ShopType> kind;    //商品分类

    String QRcode;     //二维码

    String BarCode;     //条码

}
