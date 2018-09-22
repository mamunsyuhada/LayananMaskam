package id.mamun.layananmaskam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnGrid;
    private Button btnList;
    private RecyclerView rvBarang;
    private ArrayList<Barang>list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGrid = findViewById(R.id.btnGrid);
        btnList = findViewById(R.id.btnList);
        
        rvBarang = findViewById(R.id.rvItem);
        rvBarang.setHasFixedSize(true);

        list = new ArrayList<>();
        list.addAll(DataBarang.getListData());

        //nampilin Grid dulu
        tampilkanRecyclerGrid();
    }

    public void btnListView(View view) {
        btnList.setBackgroundResource(R.drawable.btn_blue);
        btnList.setTextColor(getResources().getColor(R.color.whiteColor));

        btnGrid.setBackgroundResource(R.drawable.btn_white);
        btnGrid.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        tampilkanRecyclerList();
    }

    private void tampilkanRecyclerList() {
        rvBarang.setLayoutManager(new LinearLayoutManager(this));
        ListBarangAdapter listBarangAdapter = new ListBarangAdapter(this);
        listBarangAdapter.setListBarang(list);
        rvBarang.setAdapter(listBarangAdapter);

    }

    public void btnGridView(View view) {
        btnGrid.setBackgroundResource(R.drawable.btn_blue);
        btnGrid.setTextColor(getResources().getColor(R.color.whiteColor));
        btnList.setBackgroundResource(R.drawable.btn_white);
        btnList.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

        tampilkanRecyclerGrid();
    }

    private void tampilkanRecyclerGrid() {
        rvBarang.setLayoutManager(new GridLayoutManager(this,2));
        GridBarangAdapter gridBarangAdapter = new GridBarangAdapter(this);
        gridBarangAdapter.setListBarang(list);
        rvBarang.setAdapter(gridBarangAdapter);
    }
}