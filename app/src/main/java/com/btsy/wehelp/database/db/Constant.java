package com.btsy.wehelp.database.db;

/**
 * Created by zhouzhongbo on 2017/11/17.
 */

public class Constant {
    String DBNAME="wehelper.db";
//  public column define
    String COLUMN_PUBLIC_DEVICEID="DEVICEID";
    String COLUMN_PUBLIC_CREATETIME="CREATETIME";
    String COLUMN_PUBLIC_MODEFYTIME="MODEFYTIME";

//  customer tab and column define
    String TAB_CUSTOMER="customer";
    String COLUMN_CUSTOMER_ID="ID";
    String COLUMN_CUSTOMER_NAME="NAME";
    String COLUMN_CUSTOMER_PHONE="PHONE";
    String COLUMN_CUSTOMER_ADDRESS="ADDRESS";
    String COLUMN_CUSTOMER_SEX="SEX";

//  user tab and column define
    String TAB_USER="user";
    String COLUMN_USER_ID="ID";
    String COLUMN_USER_NAME="NAME";
    String COLUMN_USER_NICKNAME="NICKNAME";
    String COLUMN_USER_ICON="ICON";
    String COLUMN_USER_SEX="SEX";
    String COLUMN_USER_CHECK="CHECK";
    String COLUMN_USER_INTEGRATION="INTEGRATION";
    String COLUMN_USER_VIP="VIP";
    String COLUMN_USER_ROLO="ROLO";

    String TAB_PRODUCT="product";
    String TAB_ORDER="order";
    String TAB_STOCK="stock";
    String TAB_VIPINFO="vip";
    String TAB_PRODUCTINORDER="productinorder";

}
