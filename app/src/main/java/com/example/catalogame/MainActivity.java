package com.example.catalogame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton botaoCategorias;
    ImageButton botaoLanc;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // remove a action bar
        setContentView(R.layout.activity_main);

        botaoCategorias = findViewById(R.id.btncat2);
        botaoLanc = findViewById(R.id.btnLanc2);

        botaoCategorias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent cat = new Intent(getApplicationContext(), Categorias.class);
                startActivity(cat);
            }
            
            public void onClick(View v) {
                
                Intent cat = new Intent(getApplicationContext(), Lancamentos.class);
                startActivity(cat);
            }
        });
    }
}
