package com.example.admin1.recycleapplication.activity;

import android.content.Context;
import android.graphics.ColorSpace;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.admin1.recycleapplication.R;
import com.example.admin1.recycleapplication.adapter.MyAdapter;
import com.example.admin1.recycleapplication.model.Model;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {

    private RecyclerView recycleView;
    private Context context;
    //private ArrayList<String> arrayList;
    public ArrayList<Model> modelList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        context = this;

        recycleView = findViewById(R.id.recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recycleView.setLayoutManager(layoutManager);



        modelList = new ArrayList<>();


        /*arrayList = new ArrayList<>();

        arrayList.add("Name");
        arrayList.add("Mobile No");
        arrayList.add("Address");*/
        ArrayList<String> strings = new ArrayList<>();
        strings.add("name 100");
        strings.add("name 101");
        strings.add("name 102");
        strings.add("name 103");
        strings.add("name 104");

        for(int i=0; i<5 ; i++) {
            Model model = new Model();
            model.name = strings.get(i);
            //model.name = "Arpita";
            model.mobileNo = "8888888888" + i;
            model.address = "Pune" + i;


            modelList.add(model);
        }

        MyAdapter myAdapter = new MyAdapter(context, modelList);
        recycleView.setAdapter(myAdapter);

    }
}
