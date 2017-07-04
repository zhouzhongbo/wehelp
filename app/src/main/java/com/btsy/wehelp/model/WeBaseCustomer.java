package com.btsy.wehelp.model;

import com.droi.sdk.core.DroiExpose;
import com.droi.sdk.core.DroiObject;

import java.util.List;

/**
 * Created by zhouzhongbo on 2017/6/26.
 */

public class WeBaseCustomer extends DroiObject {

    @DroiExpose
    String customerName;    //商品名称

    @DroiExpose
    String phoneNumber;    //客户手机号码

    @DroiExpose
    List<String> address;    //客户手机号码 分段如何记录？struct？

}
