package com.example.dallyproject.Calendario;

import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dallyproject.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Calendario extends AppCompatActivity {
    private CalendarView calendarView;
    private EditText editTextNombreEvento;

    private String stringDateSelected;
    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);



        calendarView = findViewById(R.id.calendarView);
        editTextNombreEvento = findViewById(R.id.editTextNombreDeEvento);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                String eventName = editTextNombreEvento.getText().toString();
                Toast.makeText(Calendario.this, "Evento: " + eventName + " Fecha: " + dayOfMonth + "/" + (month + 1) + "/" + year, Toast.LENGTH_SHORT).show();
                stringDateSelected= Integer.toString(year) + Integer.toString(month+1)  +  Integer.toString(dayOfMonth+1);
                calendarClicked();
            }
        });
        databaseReference = FirebaseDatabase.getInstance().getReference("Calendar");




    }
    private void calendarClicked(){
        databaseReference.child(stringDateSelected).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if ( snapshot.getValue() != null ){
                    editTextNombreEvento.setText(snapshot.getValue().toString());

                }else {
                    editTextNombreEvento.setText("null");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public void buttonSaveEvent(View view){
        databaseReference.child(stringDateSelected).setValue(editTextNombreEvento.getText().toString());
    }
}
