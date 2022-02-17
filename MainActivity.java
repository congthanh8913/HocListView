package com.thanh.baihoclistviewnangcao_lamlai;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import adapter.SanPhamAdapter;
import model.SanPham;

public class MainActivity extends AppCompatActivity {
    ListView lvSanPham;
    SanPhamAdapter sanPhamAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControlls();
        addEvent();
        addProduct();
    }

    private void addProduct() {

        sanPhamAdapter.add(new SanPham(R.drawable.hinh1, "COCACOLA", 15000));
        sanPhamAdapter.add(new SanPham(R.drawable.hinh2, "TRÀ CÚC", 25000));
        sanPhamAdapter.add(new SanPham(R.drawable.hinh3, "TRÀ ĐÀO", 35000));
        sanPhamAdapter.add(new SanPham(R.drawable.hinh4, "TRÀ MẬN", 28000));
        sanPhamAdapter.add(new SanPham(R.drawable.hinh5, "TRÀ NHÀI", 18000));
        sanPhamAdapter.add(new SanPham(R.drawable.hinh6, "TRÀ HỒNG", 23000));
    }

    private void addEvent() {
        lvSanPham.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SanPham sp = sanPhamAdapter.getItem(i);
                Toast.makeText(MainActivity.this, "Bạn chọn sản phẩm: " + sp.getTen(), Toast.LENGTH_SHORT).show();
            /* btnDatMua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Bạn đã đặt mua "+sp.getTen()+"\n Số lượng: "+sp.getSoLuongMua()+"", Toast.LENGTH_SHORT).show();
            }
        }); */
            }
        });
    }

    private void addControlls() {
        lvSanPham = (ListView) findViewById(R.id.lvSanPham);
        sanPhamAdapter = new SanPhamAdapter(MainActivity.this, R.layout.item);

// gán sanPhamAdapter cho ListView
        lvSanPham.setAdapter(sanPhamAdapter);
    }
}