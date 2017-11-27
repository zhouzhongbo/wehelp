package com.btsy.wehelp.database.dao;

/**
 * Created by zzb on 2017/11/24.
 */

public class ShopUser {
    String userName;    //用户名

    String nickname;    //昵称

    String userIcon;    //用户头像

    boolean Sex;    //用户性别

    int checkin;    //签到

    int integration;    //积分

    String address;    //地址信息

    boolean isVip;    //vip

    int vipInfoId;
//    WeVipInfo vipInfo;    //vip相关信息(权限使用，期限等)

    String rolo;    //考虑到后续分工需要的，账号权限分级
}
