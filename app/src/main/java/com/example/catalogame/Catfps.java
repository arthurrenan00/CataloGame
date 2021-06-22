package com.example.catalogame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Catfps extends AppCompatActivity {
    
    ImageButton botaoCate;
    ImageButton botaoHom;
    ImageButton botaoLanc;
    ImageButton botaoBf2042;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catfps);
        getSupportActionBar().hide();

        botaoCate = findViewById(R.id.btncatterror);
        botaoHom = findViewById(R.id.btnhometerror);
        botaoLanc = findViewById(R.id.btnlancterror);
        botaoBf2042 = findViewById(R.id.btnbf2042);
        
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

        botaoLanc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent lanc = new Intent(getApplicationContext(), Lancamentos.class);
                startActivity(lanc);
            }

        });

        botaoBf2042.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent bf = new Intent(getApplicationContext(), Bf2042.class);
                startActivity(bf);
            }
        });
    }
}
