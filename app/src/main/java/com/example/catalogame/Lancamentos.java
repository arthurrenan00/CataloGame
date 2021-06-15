package com.example.catalogame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Lancamentos extends AppCompatActivity {

    ImageButton botaoCate;
    ImageButton botaoHom;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_lancamentos);
        
        botaoCate = findViewById(R.id.btncat3);
        botaoHom = findViewById(R.id.btnhome3);

        botaoCate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent cate = new Intent(getApplicationContext(), Categorias.class);
                startActivity(cate);
            }
            
        });
        
        botaoHom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ho = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(ho);
            }
            
        });
    }
}
