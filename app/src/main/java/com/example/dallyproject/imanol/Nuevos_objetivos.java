package com.example.dallyproject.imanol;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dallyproject.R;

public class Nuevos_objetivos extends AppCompatActivity {
    private EditText nombre;
    private EditText lugar;
    private Button btnCancelar;
    private Button btnGuardar;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevos_objetivos);

        nombre = findViewById(R.id.editTxtNombre);
        lugar = findViewById(R.id.editTxtLugar);
        btnCancelar = findViewById(R.id.btnCancelar);
        btnGuardar = findViewById(R.id.btnGuardar);
        DB = new DBHelper(this);

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreTXT = nombre.getText().toString();
                String lugarTXT = lugar.getText().toString(); // Aquí deberías obtener el texto del campo "lugar"

                Boolean checkInsertData = DB.insertTematicaData(nombreTXT, lugarTXT);
                if (checkInsertData){
                    Toast.makeText(Nuevos_objetivos.this, "Nueva entrada insertada con éxito", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Nuevos_objetivos.this, "No se ha podido insertar la nueva entrada", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
