package com.btsy.wehelp.database.dao;

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


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public DroiFile getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(DroiFile userIcon) {
        this.userIcon = userIcon;
    }

    public sexvalue getSex() {
        return Sex;
    }

    public int getCheckin() {
        return checkin;
    }

    public void setCheckin(int checkin) {
        this.checkin = checkin;
    }

    public int getIntegration() {
        return integration;
    }

    public void setIntegration(int integration) {
        this.integration = integration;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean vip) {
        isVip = vip;
    }

    public WeVipInfo getVipInfo() {
        return vipInfo;
    }

    public void setVipInfo(WeVipInfo vipInfo) {
        this.vipInfo = vipInfo;
    }

    public String getRolo() {
        return rolo;
    }

    public void setRolo(String rolo) {
        this.rolo = rolo;
    }
}
