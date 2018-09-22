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
        ListViewHolder listViewHolder = new ListViewHolder(listView);
        return listViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Barang mBarang = getListBarang().get(position);
        holder.tvNamaBarang.setText(mBarang.getNamaBarang());
        holder.tvAvailable.setText("tersedia : " + mBarang.getTersedia());
        Glide.with(context)
                .load(mBarang.getIcon())
                .transition(withCrossFade())
                .apply(new RequestOptions()
                        .error(R.drawable.ico_default_barang).centerCrop())
                .into(holder.imgIcon);

    }

    @Override
    public int getItemCount() {
        return getListBarang().size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {

        CardView gridLay;
        TextView tvAvailable;
        ImageView imgIcon;
        TextView tvNamaBarang;

        ListViewHolder(View itemView) {
            super(itemView);

            tvNamaBarang = itemView.findViewById(R.id.tvNamaBarang);
            imgIcon = itemView.findViewById(R.id.imgIcon);
            tvAvailable = itemView.findViewById(R.id.tvAvaliable);
            gridLay = itemView.findViewById(R.id.gridItem);
        }
    }
}
