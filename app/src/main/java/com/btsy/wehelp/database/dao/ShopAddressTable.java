package com.btsy.wehelp.database.dao;

/**
 * Created by zzb on 2017/11/24.
 */

public class ShopAddressTable {
    //address id
    int aid;
    //address parent id
    int pid;
    //address type 0:p,1:s,2:q;
    int type;
    //address value
    String value;

    //云数据同步，先考虑本地
    boolean isaync;
    boolean isdelete;
}
