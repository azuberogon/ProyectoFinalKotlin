package com.example.dallyproject.imanol;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dallyproject.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private ArrayList nombreID, lugarID;

    public MyAdapter(Context context, ArrayList nombreID, ArrayList lugarID) {
        this.context = context;
        this.nombreID = nombreID;
        this.lugarID = lugarID;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.tematica_entry,parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nombreID.setText(String.valueOf(nombreID.get(position)));
        holder.lugarID.setText(String.valueOf(lugarID.get(position)));
    }

    @Override
    public int getItemCount() {
        return nombreID.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nombreID, lugarID;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreID = itemView.findViewById(R.id.editTxtNombre);
            lugarID = itemView.findViewById(R.id.editTxtLugar);
        }
    }
}
