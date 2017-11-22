package com.btsy.wehelp.database.db;

import android.database.sqlite.SQLiteDatabase;

import com.btsy.wehelp.BaseApplication;

/**
 * Created by zzb on 2017/11/21.
 */

public class DbManager {
    private static DbManager manager;
    private MySQLiteOpenHelper mySQLiteOpenHelper;
    private SQLiteDatabase db;

    /**
     * 私有化构造器
     */
    private DbManager() {
        //创建数据库
        mySQLiteOpenHelper = MySQLiteOpenHelper.getInstance(BaseApplication.getContext());
        if (db == null) {
            db = mySQLiteOpenHelper.getWritableDatabase();
        }
    }

    /**
     * 单例DbManager类
     *
     * @return 返回DbManager对象
     */
    public static DbManager newInstances() {
        if (manager == null) {
            manager = new DbManager();
        }
        return manager;
    }

    /**
     * 获取数据库的对象
     *
     * @return 返回SQLiteDatabase数据库的对象
     */
    public SQLiteDatabase getDataBase() {
        return db;
    }



    public void realseDB(){
        if(db != null){
            db.close();
        }
    }
}
