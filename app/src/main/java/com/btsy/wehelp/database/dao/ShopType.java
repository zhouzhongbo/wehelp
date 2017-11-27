package com.btsy.wehelp.database.dao;

/**
 * Created by zzb on 2017/11/24.
 */

public class ShopType {

//  分类ID
    int tid;
//  分类名称
    String tname;
//  parent id
    int tpid;
//  parent name
    String pname;

    //云数据同步，先考虑本地
    boolean isaync;
    boolean isdelete;
}
