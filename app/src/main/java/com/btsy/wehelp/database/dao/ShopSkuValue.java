package com.btsy.wehelp.database.dao;

/**
 * Created by zzb on 2017/11/24.
 */

public class ShopSkuValue {
    //sku  id
    int skvid;
    //sku attr ref
    int skaid;
    //sku name
    String sname;

    //云数据同步，先考虑本地
    boolean isaync;
    boolean isdelete;

}
