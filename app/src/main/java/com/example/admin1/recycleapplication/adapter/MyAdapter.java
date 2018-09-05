package com.example.admin1.recycleapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin1.recycleapplication.R;
import com.example.admin1.recycleapplication.model.Model;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    //ArrayList<String> arrayList;
    ArrayList<Model> modelList;
    Context context;

    public MyAdapter(Context context, ArrayList<Model> modelList) {
        //this.arrayList = arrayList;
        this.context = context;
        this.modelList = modelList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.cell_sample, parent, false);
        MyAdapter.ViewHolder viewHolder = new  MyAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtName.setText(modelList.get(position).getName());
        holder.txtMobileNo.setText(modelList.get(position).getMobileNo());
        holder.txtAddress.setText(modelList.get(position).getAddress());
    }

    @Override
    public int getItemCount() {
        /*if(arrayList != null && arrayList.size() > 0){
            return arrayList.size();
        }*/
        if(modelList != null && modelList.size() > 0) {
            return modelList.size();
        }
        else
            return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtName, txtMobileNo, txtAddress;

        public ViewHolder(View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txt_name);
            txtMobileNo = itemView.findViewById(R.id.txt_mobile_no);
            txtAddress = itemView.findViewById(R.id.txt_address);

        }
    }
}





