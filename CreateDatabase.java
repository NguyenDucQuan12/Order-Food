package com.example.dauhouse.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class CreateDatabase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 3;
    private static final String DATABASE_NAME = "dataApp.db";

    public static final String tb_NHANVIEN="NHANVIEN";
    public static final String tb_LOAIMONAN="LOAIMONAN";
    public static final String tb_MONAN="MONAN";
    public static final String tb_BANAN="BANAN";
    public static final String tb_GOIMON="GOIMON";
    public static final String tb_CHITIETGOIMON="CHITIETGOIMON";

    public static final String tb_NHANVIEN_MANV="MANV";
    public static final String tb_NHANVIEN_TENDN="TENDN";
    public static final String tb_NHANVIEN_MATKHAU="MATKHAU";
    public static final String tb_NHANVIEN_CMND="CMND";
    public static final String tb_NHANVIEN_NGAYSINH="NGAYSINH";
    public static final String tb_NHANVIEN_GIOITINH="GIOITINH";

    public static final String tb_MONAN_MAMONAN="MAMONAN";
    public static final String tb_MONAN_TENMONAN="TENMONAN";
    public static final String tb_MONAN_GIA="GIA";
    public static final String tb_MONAN_MALOAIMONAN="MALOAIMONAN";
    public static final String tb_MONAN_SIZE="SIZE";

    public static final String tb_LOAIMONAN_MALOAIMONAN="MALOAIMONAN";
    public static final String tb_LOAIMONAN_TENLOAIMONAN="TENLOAIMONAN";

    public static final String tb_BANAN_MABAN="MABAN";
    public static final String tb_BANAN_TENBAN="TENBAN";
    public static final String tb_BANAN_TINHTRANG="TINHTRANG";

    public static final String tb_GOIMON_MAGOIMON="MAGOIMON";
    public static final String tb_GOIMON_MANV="MANV";
    public static final String tb_GOIMON_NGAYGOI="NGAY";
    public static final String tb_GOIMON_TINHTRANG="TINHTRANG";
    public static final String tb_GOIMON_MABAN="GOIMON";

    public static final String tb_CHITIETGOIMON_MAGOIMON="MAGOIMON";
    public static final String tb_CHITIETGOIMON_MAMONAN="CHITIETGOIMON";
    public static final String tb_CHITIETGOIMON_SOLUONG="SOLUONG";

    public CreateDatabase( Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

      //  String tbNHANVIEN="CREATE TABLE tb_NHANVIEN( tb_NHANVIEN_MANV INTEGER primary key, tb_NHANVIEN_TENDN TEXT, tb_NHANVIEN_MATKHAU TEXT, tb_NHANVIEN_CMND INTEGER, tb_NHANVIEN_NGAYSINH TEXT, tb_NHANVIEN_GIOITINH TEXT)";
      //  String tbMONAN="CREATE TABLE tb_MONAN( tb_MAMONAN INTEGER primary key, tb_MONAN_TENMONAN TEXT, tb_MONAN_GIA INTEGER, tb_MONAN_MALOAIMONAN TEXT, tb_MONAN_SIZE TEXT)";
      //  String tbLOAIMONAN="CREATE TABLE tb_LOAIMONAN( tb_MALOAIMONAN INTEGER primary key, tb_TENLOAIMONAN TEXT)";
      //  String tbBANAN="CREATE TABLE tb_BANAN( tb_MABAN INTEGER primary key, tb_BANAN_TENBAN TEXT, tb_TINHTRANG TEXT)";
      //  String tbGOIMON="CREATE TABLE tb_GOIMON( tb_GOIMON_MAGOIMON INTEGER primary key, tb_GOIMON_MANV TEXT, tb_GOIMON_NGAY TEXT, tb_GOIMON_TINHTRAANG TEXT, tb_GOIMON_MABAN INTEGER)";
      //  String tbCHITIETGOIMON="CREATE TABLE tb_CHITIETGOIMON( tb_CHITIETGOIMON_MAGOIMON INTEGER primary key, tb_CHITIETGOIMON_MAMONAN INTEGER, tb_CHITIETGOIMON_SOLUONG INTEGER)";

      //"CREATE TABLE" khác với "CREATE TABLE " con mẹ nó, có dấu cách giữa chữ table với ", mất 1 tuần ko biết lỗi là gì
        String tbNHANVIEN = "CREATE TABLE " + tb_NHANVIEN + " ( " + tb_NHANVIEN_MANV + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + tb_NHANVIEN_TENDN + " TEXT, " + tb_NHANVIEN_MATKHAU + " TEXT, " + tb_NHANVIEN_GIOITINH + " TEXT, " + tb_NHANVIEN_NGAYSINH + " TEXT, "
                + tb_NHANVIEN_CMND + " INTEGER )";

       String tbBANAN = "CREATE TABLE " + tb_BANAN + " ( "+ tb_BANAN_MABAN + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                tb_BANAN_TENBAN + " TEXT, " + tb_BANAN_TINHTRANG + " TEXT )";

        String tbMONAN = "CREATE TABLE " + tb_MONAN + " ( " + tb_MONAN_MAMONAN + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                 tb_MONAN_TENMONAN + " TEXT, "+ tb_MONAN_GIA +" TEXT, "+tb_MONAN_MALOAIMONAN +" TEXT," + tb_MONAN_SIZE +
                " TEXT )";
        String tbLOAIMONAN = "CREATE TABLE " + tb_LOAIMONAN + " ( " + tb_LOAIMONAN_MALOAIMONAN + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + tb_LOAIMONAN_TENLOAIMONAN + " TEXT )";
        String tbGOIMON = "CREATE TABLE " + tb_GOIMON + " ( " + tb_GOIMON_MAGOIMON + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                tb_GOIMON_MANV + " INTEGER, " + tb_GOIMON_NGAYGOI + " TEXT, "+ tb_GOIMON_TINHTRANG + " TEXT, " + tb_GOIMON_MABAN
                + " TEXT )";
        String tbCHITIETGOIMON = "CREATE TABLE " + tb_CHITIETGOIMON + " ( " + tb_CHITIETGOIMON_MAGOIMON + " INTEGER, "
                + tb_CHITIETGOIMON_MAMONAN+ " INTEGER, " + tb_CHITIETGOIMON_SOLUONG + " INTEGER, " + " PRIMARY KEY ( " + tb_CHITIETGOIMON_MAMONAN +
                "," + tb_CHITIETGOIMON_MAGOIMON + "))";

        db.execSQL(tbNHANVIEN);
        db.execSQL(tbMONAN);
        db.execSQL(tbLOAIMONAN);
        db.execSQL(tbBANAN);
        db.execSQL(tbGOIMON);
        db.execSQL(tbCHITIETGOIMON);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+tb_NHANVIEN);
        db.execSQL("DROP TABLE IF EXISTS "+tb_MONAN);
        db.execSQL("DROP TABLE IF EXISTS "+tb_LOAIMONAN);
        db.execSQL("DROP TABLE IF EXISTS "+tb_BANAN);
        db.execSQL("DROP TABLE IF EXISTS "+tb_GOIMON);
        db.execSQL("DROP TABLE IF EXISTS "+tb_CHITIETGOIMON);
        onCreate(db);
    }

    public SQLiteDatabase open(){

        return this.getWritableDatabase();
    }
}
