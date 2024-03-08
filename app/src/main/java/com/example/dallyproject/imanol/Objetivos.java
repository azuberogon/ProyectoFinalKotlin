package com.example.dallyproject.imanol;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dallyproject.R;
import com.example.dallyproject.databinding.ActivityObjetivosBinding;

import java.util.ArrayList;

public class Objetivos extends Fragment {

    private ActivityObjetivosBinding binding;
    private RecyclerView recyclerView;
    private ArrayList<String> nombres, lugares;
    private DBHelper DB;
    private MyAdapter adapter;
    private Button btnAgregarTematica;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DB = new DBHelper(getContext());
        nombres = new ArrayList<>();
        lugares = new ArrayList<>();
        adapter = new MyAdapter(getContext(), nombres, lugares);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = ActivityObjetivosBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        recyclerView = view.findViewById(R.id.recyclerViewObjetivos);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        btnAgregarTematica = view.findViewById(R.id.btnAgregarTematica);
        btnAgregarTematica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Nuevos_objetivos.class);
                startActivity(intent);
            }
        });

        displayData();

        return view;
    }

    private void displayData() {
        Cursor cursor = DB.getData();
        if (cursor.getCount() == 0) {
            Toast.makeText(getContext(), "No existe ninguna entrada", Toast.LENGTH_SHORT).show();
            return;
        }else{
            while (cursor.moveToNext()){
                nombres.add(cursor.getString(0));
                lugares.add(cursor.getString(1));
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
