package com.btsy.wehelp.database.dao;

import com.droi.sdk.core.DroiExpose;
import com.droi.sdk.core.DroiObject;

import java.util.List;

/**
 * Created by zhouzhongbo on 2017/6/26.
 */
//客户信息描述
public class WeCustomer extends DroiObject {

    @DroiExpose
    String customerName;    //商品名称

    @DroiExpose
    String phoneNumber;    //客户手机号码

    @DroiExpose
    List<String> address;    //客户手机号码 分段如何记录？struct？

    @DroiExpose
    boolean  sex;   //性别

    @DroiExpose
    List<String>  tag;      //标签描述，后续可能会有用(客服分类等)

}
