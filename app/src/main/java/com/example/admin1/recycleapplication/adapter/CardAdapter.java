package com.example.admin1.recycleapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin1.recycleapplication.R;
import com.example.admin1.recycleapplication.model.CardModel;

import java.util.ArrayList;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.MyView>{

    Context context;
    ArrayList<CardModel> arrayList;
    //ArrayList<CardModel> cardModels;

    public CardAdapter(Context context, ArrayList<CardModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        //this.cardModels = cardModels;
    }

    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.card_view,parent,false);
        MyView myView = new MyView(v);
        return myView;
    }

    @Override
    public void onBindViewHolder(@NonNull MyView holder, int position) {
        holder.txtNo.setText(arrayList.get(position).no);
        holder.txtBynry.setText(arrayList.get(position).bynry);
        holder.txtAddress.setText(arrayList.get(position).address);
        holder.txtDetails.setText(arrayList.get(position).details);
        holder.txtDelete.setText(arrayList.get(position).delete);

    }

    @Override
    public int getItemCount() {
        if(arrayList != null && arrayList.size() > 0){
            return arrayList.size();
        }
        else
            return  0;
    }

    public class MyView extends RecyclerView.ViewHolder {
        TextView txtNo, txtBynry, txtAddress, txtDetails, txtDelete;
        public MyView(View itemView) {
            super(itemView);
            txtNo = itemView.findViewById(R.id.txt_no);
            txtBynry = itemView.findViewById(R.id.txt_bynry);
            txtAddress = itemView.findViewById(R.id.txt_address);
            txtDetails = itemView.findViewById(R.id.txt_details);
            txtDelete = itemView.findViewById(R.id.txt_delete);
        }
    }
}
