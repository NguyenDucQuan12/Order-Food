package com.example.dauhouse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.dauhouse.DAO.NhanVienDAO;
import com.example.dauhouse.DTO.NhanVienDTO;
import com.example.dauhouse.Database.CreateDatabase;
import com.example.dauhouse.FragmentApp.DatePickerFragment;

public class Dangky extends AppCompatActivity implements View.OnClickListener, View.OnFocusChangeListener {

    EditText edTenDangNhapDK,edMatKhauDk,edNgaySinhDK,edCCCDDK;
    Button btnDongYDK,btnThoatDK;
    RadioGroup rgGioiTinh;

    String sGioitinh;

    NhanVienDAO nhanVienDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dangky);

        edTenDangNhapDK=findViewById(R.id.edTenDangNhapDK);
        edMatKhauDk=findViewById(R.id.edMatKhauDK);
        edNgaySinhDK=findViewById(R.id.edNgaySinhDK);
        edCCCDDK=findViewById(R.id.edCCCDDK);

        btnDongYDK=findViewById(R.id.btnDongYDK);
        btnThoatDK=findViewById(R.id.btnThoatDK);

        rgGioiTinh=findViewById(R.id.rgGioiTinh);

        btnDongYDK.setOnClickListener(this);
        btnThoatDK.setOnClickListener(this);
        edNgaySinhDK.setOnFocusChangeListener(this);
        nhanVienDAO=new NhanVienDAO(this);


    }

    @Override
    public void onClick(View view) {

        int id=view.getId();
        switch (id){
            case R.id.btnDongYDK:
                String sTenDangnhap=edTenDangNhapDK.getText().toString();
                String sMatKhau=edNgaySinhDK.getText().toString();

                switch (rgGioiTinh.getCheckedRadioButtonId()){
                    case R.id.rdNam:
                        sGioitinh="Nam";
                        break;
                    case R.id.rdNu:
                        sGioitinh="Nữ";
                        break;
                }

                String sNgaySinh=edNgaySinhDK.getText().toString();
                int sCCCDDK= Integer.parseInt(edCCCDDK.getText().toString());

                if(sTenDangnhap==null || sTenDangnhap.equals("")){ //ko sử dụng == để so sánh chuỗi string

                    Toast.makeText(Dangky.this, getResources().getString(R.string.NhaptenDK), Toast.LENGTH_SHORT).show();
                }else if(sMatKhau==null||sMatKhau.equals("")){
                    Toast.makeText(Dangky.this, getResources().getString(R.string.NhaptenDK), Toast.LENGTH_SHORT).show();
                }else
                {

                    NhanVienDTO nhanVienDTO=new NhanVienDTO();
                    nhanVienDTO.setTENDN(sTenDangnhap);
                    nhanVienDTO.setMATKHAU(sMatKhau);
                    nhanVienDTO.setCMND(sCCCDDK);
                    nhanVienDTO.setGIOITINH(sGioitinh);
                    nhanVienDTO.setNGAYSINH(sNgaySinh);

                    long kiemtra=  nhanVienDAO.ThemNhanVien(nhanVienDTO);
                    if(kiemtra != 0){
                        Toast.makeText(Dangky.this, getResources().getString(R.string.Themthanhcong), Toast.LENGTH_SHORT).show();
                    } else
                        Toast.makeText(Dangky.this, getResources().getString(R.string.Themthatbai), Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.btnThoatDK:
                finish();
                break;
        }

    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        int id= v.getId();
        switch(id){
            case R.id.edNgaySinhDK:
                if(hasFocus){
                    //xuat popup ngay sinh
                    DatePickerFragment datePickerFragment=new DatePickerFragment();
                    datePickerFragment.show(getSupportFragmentManager(),"Ngày Sinh");
                }
                ;break;
        }

    }
}