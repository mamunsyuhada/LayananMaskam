package id.mamun.layananmaskam;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class DetailActivity extends AppCompatActivity {

    private ArrayList<Barang> listBarang;
    private TextView tvNamaBarang;
    private ImageView imgBarang;
    private TextView tvHarga;
    private TextView tvTersedia;
    private TextView tvDeskripsi;
    private ImageView imgIcon;

    public DetailActivity(ArrayList<Barang> listBarang) {
        this.listBarang = listBarang;
    }

    public ArrayList<Barang> getListBarang(){
        return listBarang;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initKomponen();

//        int posisi = getIntent().getIntExtra("POSISI",0);

//        tvNamaBarang.setText(mBarang.getNamaBarang());
//        Picasso.get()
//                .load("https://raw.githubusercontent.com/mamunsyuhada/LayananMaskam/master/image-doc/gamabar-barang/"
//                        + mBarang.getImg()
//                        + ".png")
//                .placeholder(R.drawable.anim_progress)
//                .error(R.drawable.img_default)
//                .into(imgBarang);
//        Picasso.get()
//                .load("https://raw.githubusercontent.com/mamunsyuhada/LayananMaskam/master/image-doc/icon-svg/"
//                        + mBarang.getImg()
//                        + ".png")
//                .placeholder(R.drawable.anim_progress)
//                .error(R.drawable.img_default)
//                .into(imgIcon);
////        int hargaBarang = Integer.parseInt(mBarang.getHarga());
////        Locale localeID = new Locale("in", "ID");
////        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
////        tvHarga.setText(formatRupiah.format((double)hargaBarang));
//        tvTersedia.setText("tersedia " + mBarang.getTersedia() + " dari " + mBarang.getTotalDefault());
//        tvDeskripsi.setText(mBarang.getDeskripsi());

    }

    private void initKomponen() {
        tvNamaBarang = findViewById(R.id.tvNamaBarang);
        imgBarang = findViewById(R.id.imgBarang);
        imgIcon = findViewById(R.id.imgIcon);
        tvHarga = findViewById(R.id.tvHarga);
        tvTersedia = findViewById(R.id.tvTersedia);
        tvDeskripsi = findViewById(R.id.tvDeskripsi);
    }

    public void aksiPesan(View view) {
        try{
            String text = "pinjam barang"; //TODO sesuai dengan barangnya
            String toNumber = "6285723910307";
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://api.whatsapp.com/send?phone=" + toNumber + "&text=" + text));
            startActivity(intent);
        }catch (Exception e){
            e.printStackTrace();
//            Toast.makeText(DetailActivity.this, "Download aplikasi Whatsapp dulu", Toast.LENGTH_LONG).show();
        }

    }
}
