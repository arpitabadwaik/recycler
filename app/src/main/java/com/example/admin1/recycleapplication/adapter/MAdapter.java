package com.example.admin1.recycleapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin1.recycleapplication.R;
import com.example.admin1.recycleapplication.model.Model;

import java.util.ArrayList;

public class MAdapter extends RecyclerView.Adapter<MAdapter.ViewHolder> {

    ArrayList<Model> modeList;
    Context context;

    public MAdapter(Context context, ArrayList<Model> modeList) {
        this.modeList = modeList;
        this.context = context;
    }

    @NonNull
    @Override
    public MAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.cell_sample, parent,false);
        MAdapter.ViewHolder viewHolder = new MAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MAdapter.ViewHolder holder, int position) {

        holder.txtName.setText(modeList.get(position).getName());
        holder.txtMobileNo.setText(modeList.get(position).getMobileNo());
        holder.txtAddress.setText(modeList.get(position).getAddress());

    }

    @Override
    public int getItemCount() {
        if(modeList != null && modeList.size() > 0){
            return modeList.size();
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
