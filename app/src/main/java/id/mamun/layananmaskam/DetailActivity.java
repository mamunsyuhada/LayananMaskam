package id.mamun.layananmaskam;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.text.NumberFormat;
import java.util.Locale;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class DetailActivity extends AppCompatActivity {

    private TextView tvNamaBarang;
    private ImageView imgBarang;
    private TextView tvHarga;
    private TextView tvTersedia;
    private TextView tvDeskripsi;
    private ImageView imgIcon;
    private Button btnAksiPesan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initKomponen();
        String namaBarang = getIntent().getStringExtra("DESKRIPSIBARANG");

        tvNamaBarang.setText(namaBarang);

        Glide.with(this)
                .load("https://raw.githubusercontent.com/mamunsyuhada/LayananMaskam/master/image-doc/gamabar-barang/"
                        + getIntent().getStringExtra("IMAGEBARANG")
                        + ".png")
                .transition(withCrossFade())
                .apply(new RequestOptions()
                        .error(R.drawable.img_default).centerCrop())
                .into(imgBarang);

        Glide.with(this)
                .load("https://raw.githubusercontent.com/mamunsyuhada/LayananMaskam/master/image-doc/icon-svg/"
                        + getIntent().getStringExtra("ICONBARANG")
                        + ".png")
                .transition(withCrossFade())
                .apply(new RequestOptions()
                        .error(R.drawable.ico_default_barang).centerCrop())
                .into(imgIcon);

        Locale localeID = new Locale("in", "ID");

        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        int hargaInt = Integer.parseInt(getIntent().getStringExtra("HARGA"));
        tvHarga.setText(formatRupiah.format(hargaInt));
        tvTersedia.setText(
                "tersedia "
                + getIntent().getStringExtra("TOTALSEKARANG")
                + " dari "
                + getIntent().getStringExtra("TOTALDEFAULT"));

        tvDeskripsi.setText(namaBarang);

        btnAksiPesan.setText("Pinjam " + namaBarang);
    }

    private void initKomponen() {
        tvNamaBarang = findViewById(R.id.tvNamaBarang);
        imgBarang = findViewById(R.id.imgBarang);
        imgIcon = findViewById(R.id.imgIcon);
        tvHarga = findViewById(R.id.tvHarga);
        tvTersedia = findViewById(R.id.tvTersedia);
        tvDeskripsi = findViewById(R.id.tvDeskripsi);
        btnAksiPesan = findViewById(R.id.btnAksiPesan);
    }

    public void aksiPesan(View view) {
        try{
            String text = "Assalaamu'alaikum, pak Udin... Saya bermaksut untuk meminjam *"
                    + getIntent().getStringExtra("NAMABARANG")
                    + "* dari Layanan Masjid Kampus UGM, pak."
                    + " Bagaimana caranya ? Trimaksih..";
            String toNumber = "6285723910307";
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://api.whatsapp.com/send?phone=" + toNumber + "&text=" + text));
            startActivity(intent);
        }catch (Exception e){
            e.printStackTrace();
//            Toast.makeText(DetailActivity.this, "Download aplikasi Whatsapp dulu", Toast.LENGTH_LONG).show();
        }

    }

    public void closeDetailActivity(View view) {
        finish();
    }
}
