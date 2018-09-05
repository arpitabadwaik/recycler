package com.example.admin1.recycleapplication.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.example.admin1.recycleapplication.R;
import com.example.admin1.recycleapplication.adapter.CardAdapter;
import com.example.admin1.recycleapplication.model.CardModel;

import java.util.ArrayList;

public class CardActivity extends AppCompatActivity {

    RecyclerView recView;
    ArrayList<CardModel> arrayList;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        context = this;

        recView = findViewById(R.id.rec_view);
        LinearLayoutManager layout =  new LinearLayoutManager(context);
        recView.setLayoutManager(layout);

        arrayList = new ArrayList<>();

        for (int i = 0; i< 2 ;i++) {

            CardModel cardModel = new CardModel();
            cardModel.no = "CONS142335353533";
            cardModel.bynry = "Bynry Technologies";
            cardModel.address = "201, Primrose Building, Kota Road, Kota Road, Kota Road, Pune - 452142";
            cardModel.details = "VIEW DETAILS";
            cardModel.delete = "DELETE";
            arrayList.add(cardModel);
        }


        CardAdapter cardAdapter= new CardAdapter(context,arrayList);
        recView.setAdapter(cardAdapter);


    }
}
