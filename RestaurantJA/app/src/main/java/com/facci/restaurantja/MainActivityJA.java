package com.facci.restaurantja;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivityJA extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_j);
    }

    public void Click1(View v){
        Toast.makeText(MainActivityJA.this,"Comida Manabita",Toast.LENGTH_SHORT).show();
    }
    public void Click2(View v){
        Toast.makeText(MainActivityJA.this,"Camarón con arroz",Toast.LENGTH_SHORT).show();
    }
    public void Click3(View v){
        Toast.makeText(MainActivityJA.this,"Pescado Apanado",Toast.LENGTH_SHORT).show();
    }
    public void Click4(View v){
        Toast.makeText(MainActivityJA.this,"Viche de Camarón",Toast.LENGTH_SHORT).show();
    }
    public void Click5(View v){
        Toast.makeText(MainActivityJA.this,"Sopa de Langostino",Toast.LENGTH_SHORT).show();
    }
    public void Click6(View v){
        Toast.makeText(MainActivityJA.this,"Arroz Marinero",Toast.LENGTH_SHORT).show();
    }
    public void Click7(View v){
        Toast.makeText(MainActivityJA.this,"Plato Especial",Toast.LENGTH_SHORT).show();
    }
}
