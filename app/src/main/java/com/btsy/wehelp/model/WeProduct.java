package com.btsy.wehelp.model;

import com.droi.sdk.core.DroiExpose;
import com.droi.sdk.core.DroiFile;
import com.droi.sdk.core.DroiObject;
import com.droi.sdk.core.DroiReference;

import java.util.List;

/**
 * Created by zhouzhongbo on 2017/6/26.
 */

public class WeProduct extends DroiObject {

    @DroiExpose
    String productName;    //商品名称

    @DroiExpose
    float priceOut;    //商品售价

    @DroiExpose
    float priceIn;    //商品进价

    @DroiExpose
    boolean isValid;    //商品信息是否可用(信息废弃)

    @DroiExpose
    DroiFile headerImage;    //商品主图

    @DroiExpose
    List<DroiFile> imagelList;    //商品描述图列表

    @DroiExpose
    String description;    //商品描述

    @DroiExpose
    String note;     //商品备注

    @DroiExpose
    String type;     //商品分类

    @DroiExpose
    String model;    //商品型号

    @DroiExpose
    String size;     //商品尺寸

    @DroiExpose
    String color;    //商品颜色

    @DroiExpose      //二维码
    String QRcode;

    @DroiExpose      //条码
    String BarCode;

}
