package id.mamun.layananmaskam;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class GridBarangAdapter extends RecyclerView.Adapter<GridBarangAdapter.GridViewHolder>{

    private Context context;
    private ArrayList<Barang> listBarang;

    public ArrayList<Barang> getListBarang(){
        return listBarang;
    }

    public void setListBarang(ArrayList<Barang> listBarang){
        this.listBarang = listBarang;
    }

    public GridBarangAdapter(Context context){
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
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
        holder.tvNamaBarang.setText(getListBarang().get(position).getNamaBarang());
        holder.tvAvailable.setText(getListBarang().get(position).getTersedia());

        Glide.with(context)
                .load(getListBarang().get(position).getIcon())
                .transition(withCrossFade())
                .apply(new RequestOptions()
                        .placeholder(R.drawable.default_barang_ico)
                        .error(R.drawable.default_barang_ico).centerCrop())
                .into(holder.imgIcon);
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