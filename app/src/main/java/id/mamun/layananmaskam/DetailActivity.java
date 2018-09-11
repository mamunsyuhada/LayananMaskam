package id.mamun.layananmaskam;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
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
