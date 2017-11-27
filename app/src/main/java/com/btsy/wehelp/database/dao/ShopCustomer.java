package com.btsy.wehelp.database.dao;

import java.util.List;

/**
 * Created by zzb on 2017/11/24.
 */

public class ShopCustomer {

    int scid;

    //客户名
    String customerName;

    //手机号
    String phoneNumber;

    int shopAddressObjectId;
//    ShopAddressObject address;    //客户手机号码 分段如何记录？struct？

    boolean  sex;   //性别

    List<String>  tag;      //标签描述，后续可能会有用(客服分类等)
}
