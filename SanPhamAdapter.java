package adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.thanh.baihoclistviewnangcao_lamlai.MainActivity;
import com.thanh.baihoclistviewnangcao_lamlai.R;

import model.SanPham;

public class SanPhamAdapter extends ArrayAdapter<SanPham> {
    Activity context;
    int resource;
    // tạo contrator 2 đối để lưu lại
    // đối số resource chính là layout đc thiết kế: item.xml
        public SanPhamAdapter(@NonNull Activity context, int resource) {
        super(context, resource);
        this.context=context;
        this.resource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // tạo inflater để lưu vào bộ nhớ
        // this.resource là Layout được thiết kế item.xml
        LayoutInflater inflater=this.context.getLayoutInflater();
        View customView = inflater.inflate(this.resource,null);

        // lấy các controll trên giao diện
        ImageView imgHinh=(ImageView) customView.findViewById(R.id.imgHinh);
        TextView txtTen=(TextView) customView.findViewById(R.id.txtTenSP);
        TextView txtGia=(TextView) customView.findViewById(R.id.txtGiaSP);
        EditText edtSoLuongMua=(EditText) customView.findViewById(R.id.edtSoLuongMua);
        TextView txtKetQua=(TextView) customView.findViewById(R.id.txtKetQua);
        Button btnDatMua=(Button)customView.findViewById(R.id.btnMuaNgay);

        // position vị trí dòng đó được nhân bản
        SanPham sp=getItem(position);

        // Sét sự kiến ấn vào Button
        btnDatMua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sl=edtSoLuongMua.getText().toString();
                int kq=Integer.parseInt(sl)*sp.getGia();
                txtKetQua.setText("Tổng tiền cần trả: "+kq);
                Toast.makeText(context, "Tổng tiền trả: "+kq, Toast.LENGTH_SHORT).show();
            }
        });

        // Hiện thị các thông tin lên giao diện
        imgHinh.setImageResource(sp.getHinh());
        txtTen.setText(sp.getTen());
        txtGia.setText(sp.getGia()+"VNĐ");

        return customView;
    }
}
