package id.mamun.layananmaskam;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ListBarangAdapter extends RecyclerView.Adapter<ListBarangAdapter.ListViewHolder>{

    private Context context;
    private ArrayList<Barang> listBarang;

    private ArrayList<Barang> getListBarang(){
        return listBarang;
    }

    public void setListBarang(ArrayList<Barang> listBarang){
        this.listBarang = listBarang;
    }

    ListBarangAdapter(Context context){
        this.context = context;
    }

    //    @NonNull nya apakah mempengaruhi

    @NonNull
    @Override
    public ListBarangAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listview_barang, parent, false);
        return new ListViewHolder(listView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, final int position) {
        final Barang mBarang = getListBarang().get(position);

        final String namaBarang = mBarang.getNamaBarang();
        final String totalSekarang = mBarang.getTersedia();
        final String totalDefault = mBarang.getTotalDefault();
        final String iconBarang = mBarang.getIcon();
        final String hargaBarang = mBarang.getHarga();
        final String imageBarang = mBarang.getImg();
        final String deskripsiBarang = mBarang.getDeskripsi();

        holder.tvNamaBarang.setText(mBarang.getNamaBarang());
        holder.tvAvailable.setText("tersedia : " + totalSekarang + " dari " + totalDefault);
//        Glide.with(context)
//                .load(Integer.parseInt(mBarang.getIcon()))
//                .transition(withCrossFade())
//                .apply(new RequestOptions()
//                        .error(R.drawable.ico_carpet).centerCrop())
//                .into(holder.imgIcon);

        Picasso.get()
                .load("https://raw.githubusercontent.com/mamunsyuhada/LayananMaskam/master/image-doc/icon-svg/"
                        + iconBarang
                        + ".png")
                .placeholder(R.drawable.anim_progress)
                .error(R.drawable.ico_default_barang)
                .into(holder.imgIcon);

        holder.listLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context, "anda memilih " +  mBarang.getNamaBarang(), Toast.LENGTH_SHORT).show();
                Intent pindahDeatail = new Intent(context, DetailActivity.class);
                pindahDeatail.putExtra("NAMABARANG", namaBarang);
                pindahDeatail.putExtra("TOTALSEKARANG", totalSekarang);
                pindahDeatail.putExtra("TOTALDEFAULT", totalDefault);
                pindahDeatail.putExtra("ICONBARANG", iconBarang);
                pindahDeatail.putExtra("HARGA", hargaBarang);
                pindahDeatail.putExtra("IMAGEBARANG", imageBarang);
                pindahDeatail.putExtra("DESKRIPSIBARANG", deskripsiBarang);
                context.startActivity(pindahDeatail);
            }
        });

    }

    @Override
    public int getItemCount() {
        return getListBarang().size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {

        LinearLayout listLay;
        TextView tvAvailable;
        ImageView imgIcon;
        TextView tvNamaBarang;

        ListViewHolder(View itemView) {
            super(itemView);

            tvNamaBarang = itemView.findViewById(R.id.tvNamaBarang);
            imgIcon = itemView.findViewById(R.id.imgIcon);
            tvAvailable = itemView.findViewById(R.id.tvAvaliable);
            listLay = itemView.findViewById(R.id.listItem);
        }
    }
}
