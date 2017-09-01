package com.btsy.wehelp.model;

import com.droi.sdk.core.DroiExpose;
import com.droi.sdk.core.DroiFile;
import com.droi.sdk.core.DroiReference;
import com.droi.sdk.core.DroiUser;

/**
 * Created by zhouzhongbo on 2017/6/26.
 */

public class WeUser extends DroiUser{

    @DroiExpose
    String userName;    //用户名

    @DroiExpose
    public String nickname;    //昵称

    @DroiExpose
    DroiFile userIcon;    //用户头像

    @DroiExpose
    sexvalue Sex;    //用户性别

    @DroiExpose
    int checkin;    //签到

    @DroiExpose
    int integration;    //积分

    @DroiExpose
    String address;    //地址信息

    @DroiExpose
    boolean isVip;    //vip

    @DroiReference
    WeVipInfo vipInfo;    //vip相关信息(权限使用，期限等)

    @DroiExpose
    String rolo;    //考虑到后续分工需要的，账号权限分级


    public void setSex(sexvalue value){
        Sex = value;
    }

    public enum sexvalue{
        male,
        female
    }

}
