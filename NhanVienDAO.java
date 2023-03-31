package com.example.dauhouse.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.dauhouse.DTO.NhanVienDTO;
import com.example.dauhouse.Database.CreateDatabase;

public class NhanVienDAO {
    SQLiteDatabase database;
    public NhanVienDAO(Context context){
        CreateDatabase creatdatabase=new CreateDatabase(context);
        database= creatdatabase.open();
    }

    public long ThemNhanVien (NhanVienDTO nhanVienDTO){
        ContentValues contentValues =new ContentValues();

        contentValues.put(CreateDatabase.tb_NHANVIEN_TENDN,NhanVienDTO.getTENDN());
        contentValues.put(CreateDatabase.tb_NHANVIEN_CMND,NhanVienDTO.getCMND());
        contentValues.put(CreateDatabase.tb_NHANVIEN_MATKHAU,NhanVienDTO.getMATKHAU());
        contentValues.put(CreateDatabase.tb_NHANVIEN_GIOITINH,NhanVienDTO.getGIOITINH());
        contentValues.put(CreateDatabase.tb_NHANVIEN_NGAYSINH,NhanVienDTO.getNGAYSINH());

        long kiemtra=database.insert(CreateDatabase.tb_NHANVIEN,null,contentValues );
        return kiemtra;
    }
}
