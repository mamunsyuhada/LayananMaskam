package id.mamun.layananmaskam;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class GridBarangAdapter extends RecyclerView.Adapter<GridBarangAdapter.GridViewHolder>{

    private Context context;
    private ArrayList<Barang> listBarang;

    private ArrayList<Barang> getListBarang(){
        return listBarang;
    }

    public void setListBarang(ArrayList<Barang> listBarang){
        this.listBarang = listBarang;
    }

    GridBarangAdapter(Context context){
        this.context = context;
    }

    //    @NonNull nya apakah mempengaruhi

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View gridView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gridview_barang, parent, false);
        return new GridViewHolder(gridView);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, final int position) {
        final Barang mBarang = getListBarang().get(position);
        holder.tvNamaBarang.setText(mBarang.getNamaBarang());
        holder.tvAvailable.setText("tersedia : " + mBarang.getTersedia() + " dari " + mBarang.getTotalDefault());

//        Glide.with(context)
//                .load(Integer.parseInt(mBarang.getIcon()))
//                .transition(withCrossFade())
//                .apply(new RequestOptions()
//                        .error(R.drawable.ico_handycam).centerCrop())
//                .into(holder.imgIcon);

        Picasso.get()
                .load("https://raw.githubusercontent.com/mamunsyuhada/LayananMaskam/master/image-doc/icon-svg/"
                        + mBarang.getIcon()
                        + ".png")
                .placeholder(R.drawable.anim_progress)
                .error(R.drawable.ico_default_barang)
                .into(holder.imgIcon);

        holder.gridLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Toast.makeText(context, "anda memilih " + mBarang.getNamaBarang(), Toast.LENGTH_SHORT).show();

                Intent pindahDeatail = new Intent(context, DetailActivity.class);
                pindahDeatail.putExtra("POSISI", position);
                context.startActivity(pindahDeatail);

            }
        });

    }

    @Override
    public int getItemCount() {
        return getListBarang().size();
    }

    class GridViewHolder extends RecyclerView.ViewHolder {

        CardView gridLay;
        TextView tvAvailable;
        ImageView imgIcon;
        TextView tvNamaBarang;

        GridViewHolder(View itemView) {
            super(itemView);

            tvNamaBarang = itemView.findViewById(R.id.tvNamaBarang);
            imgIcon = itemView.findViewById(R.id.imgIcon);
            tvAvailable = itemView.findViewById(R.id.tvAvaliable);
            gridLay = itemView.findViewById(R.id.gridItem);
        }
    }
}