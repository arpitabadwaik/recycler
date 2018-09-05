package com.example.admin1.recycleapplication.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.admin1.recycleapplication.R;
import com.example.admin1.recycleapplication.adapter.MAdapter;
import com.example.admin1.recycleapplication.model.Model;

import java.util.ArrayList;

public class RecyActivity extends AppCompatActivity {

    RecyclerView rec;
    Context context;
    ArrayList<Model> modeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recy);

        rec = findViewById(R.id.rec_view);
        context = this;

        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        rec.setLayoutManager(layoutManager);

        modeList = new ArrayList<>();

        Model mo = new Model();
        mo.name = "Twinkle";
        mo.mobileNo = "8483003504";
        mo.address = "Amravati";
        modeList.add(mo);

        MAdapter mAdapter = new MAdapter(context, modeList);
        rec.setAdapter(mAdapter);

    }
}
