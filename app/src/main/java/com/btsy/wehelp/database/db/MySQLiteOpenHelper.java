package com.btsy.wehelp.database.db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by zhouzhongbo on 2017/11/17.
 */

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    private static  MySQLiteOpenHelper helper;

    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }


    //为了简化构造器的使用，我们自定义一个构造器
    private MySQLiteOpenHelper(Context context, String name) {
        this(context, name, null, 1);//传入Context和数据库的名称，调用上面那个构造器
    }

    //将自定义的数据库创建类单例。
    public static  synchronized  MySQLiteOpenHelper getInstance(Context context) {
        if(helper==null){
            helper = new MySQLiteOpenHelper(context, "DayDayUpDb");//数据库名称为create_db。
        }
        return  helper;
    }


    @Override
    public String getDatabaseName() {
        return super.getDatabaseName();
    }

    @Override
    public void setWriteAheadLoggingEnabled(boolean enabled) {
        super.setWriteAheadLoggingEnabled(enabled);
    }

    @Override
    public SQLiteDatabase getWritableDatabase() {
        return super.getWritableDatabase();
    }

    @Override
    public SQLiteDatabase getReadableDatabase() {
        return super.getReadableDatabase();
    }

    @Override
    public synchronized void close() {
        super.close();
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create address table
        db.execSQL("CREATE TABLE ADDRESS （AID INT,PID INT,TYPE INT,NAME TEXT)");
        db.execSQL("CREATE TABEL BRAND (BID INT,BNAME TEXT,BDESC TEXT,ISAYNC INT,ISDELETE INT)");
        db.execSQL("CREATE TABEL ADDRESSDATA(_ID INT,PID INT,PVALUE TEXT,CID INT,CVALUE TEXT,AID INT,AVALUE TEXT,DETAIL TEXT)");
        db.execSQL("CREATE TABEL CUSTOMER(SCID INT,CUSNAME TEXT,PHONE STRING,SAOID INT,SEX INT,TAG TEXT");
        db.execSQL("CREATE TABEL SKUATTR(SAID INT,SANAME TEXT,ISAYNC INT,ISDELETE INT)");
        db.execSQL("CREATE TABEL SKUVALUE(SKVID INT,SKAID INT,SVNAME TEXT,ISAYNC INT,ISDELETE INT)");
        db.execSQL("CREATE TABEL TYPE(TID INT,TNAME TEXT,TPID INT,TPNAME TEXT,ISAYNC INT,ISDELETE INT)");

        db.execSQL("CREATE TABEL USER(UID INT,USERNAME TEXT,NICKNAME TEXT,USERICON TEXT,SEX INT,CHECK INT,INTEGRATION INT,SAOID INT,TPNAME TEXT,ISAYNC INT,ISDELETE INT)");


        db.execSQL("CREATE TABEL TYPE(TID INT,TNAME TEXT,TPID INT,TPNAME TEXT,ISAYNC INT,ISDELETE INT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
