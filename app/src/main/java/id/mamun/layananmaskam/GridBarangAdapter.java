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

import java.util.ArrayList;

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
        GridViewHolder gridViewHolder = new GridViewHolder(gridView);
        return gridViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, final int position) {
        final Barang mBarang = getListBarang().get(position);
        holder.tvNamaBarang.setText(mBarang.getNamaBarang());
        holder.tvAvailable.setText("tersedia : " + mBarang.getTersedia());

        holder.gridLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, mBarang.getIcon(), Toast.LENGTH_SHORT).show();


//                Intent pindahDeatail = new Intent(context, DetailActivity.class);

//                pindahDeatail.putExtra("POSISI", position);
////                pindahDeatail.putExtra("TOTAL_TERSEDIA", totTersedia);
////                pindahDeatail.putExtra("IMG_ICON", imgIcon);
////                pindahDeatail.putExtra("NAMA_BARANG", imgIcon); TODO gambar

//                context.startActivity(pindahDeatail);

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