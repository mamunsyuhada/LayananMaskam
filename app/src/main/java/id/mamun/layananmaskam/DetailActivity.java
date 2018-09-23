package id.mamun.layananmaskam;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class DetailActivity extends AppCompatActivity {

    private String namaBarang;
    private String imgIcon;
    private String totTersedia;
    private String hargaBarang;
    private String totDefault;
    private String deskripsiBarang;

    private ArrayList<Barang> listBarang;
    private TextView tvNamaBarang;
    private ImageView imgBarang;
    private TextView tvHarga;
    private TextView tvTersedia;
    private TextView tvDeskripsi;

    public ArrayList<Barang> getListBarang(){
        return listBarang;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initKomponen();

//        int posisi = getIntent().getIntExtra("POSISI",0);
//        Barang b = getListBarang().get(posisi);
//        namaBarang = b.getNamaBarang();
//        totTersedia = b.getTersedia();
//        imgIcon = b.getIcon();
//
//        Log.d("data Put Extra", Integer.toString(posisi)
//                + "{" +namaBarang + " & "
//                + totTersedia + " & "
//                + imgIcon + "}");
    }

    private void initKomponen() {
        tvNamaBarang = findViewById(R.id.tvNamaBarang);
        imgBarang = findViewById(R.id.imgBarang);
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
