package id.mamun.layananmaskam;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    private String namaBarang;
    private String imgIcon;
    private String totTersedia;
    private int posisi;


    private ArrayList<Barang> listBarang;

    public ArrayList<Barang> getListBarang(){
        return listBarang;
    }

    public void setListBarang(ArrayList<Barang> listBarang){
        this.listBarang = listBarang;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        posisi = getIntent().getIntExtra("POSISI",0);

        namaBarang = getListBarang().get(posisi).getNamaBarang();
        totTersedia = getListBarang().get(posisi).getTersedia();
        imgIcon = getListBarang().get(posisi).getIcon();
        Log.d("data Put Extra", Integer.toString(posisi)
                + "{" +namaBarang + " & "
                + totTersedia + " & "
                + imgIcon + "}");

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
