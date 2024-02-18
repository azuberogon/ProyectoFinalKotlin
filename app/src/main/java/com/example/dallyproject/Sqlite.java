package com.example.dallyproject;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dallyproject.db.DbHelper;

public class Sqlite extends AppCompatActivity {
    Button btnCrear;
    @Override
    protected void onCreate(Bundle savedInstanceStae){
        super.onCreate(savedInstanceStae);
        setContentView(R.layout.activity_main);
        btnCrear = findViewById(R.id.btnLoggin);


        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbHelper dbHelper = new DbHelper(Sqlite.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                if (db != null){
                    Toast.makeText(Sqlite.this, "BASE DE DATOS CREADA", Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}
