package com.sum.rvadapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.sum.adapter.RecyclerAdapter;
import com.sum.adapter.RecyclerDataHolder;
import com.sum.adapter.line.ItemSpaceDecoration;
import com.sum.rvadapter.ui.ColorHolder;

import java.util.ArrayList;
import java.util.List;

public class SpaceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_space);

        RecyclerAdapter adapter = new RecyclerAdapter();

        RecyclerView rv_1 = findViewById(R.id.rv_1);
        rv_1.setLayoutManager(new GridLayoutManager(this,3));
        rv_1.addItemDecoration(new ItemSpaceDecoration());
        rv_1.setAdapter(adapter);

        List<RecyclerDataHolder> holders = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            holders.add(new ColorHolder(null));
        }

        adapter.setDataHolders(holders);
    }
}