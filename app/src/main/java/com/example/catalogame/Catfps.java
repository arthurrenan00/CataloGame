package com.example.catalogame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Catfps extends AppCompatActivity {

    ImageButton botaoCate;
    ImageButton botaoHom;
    ImageButton botaoLanc;
    ImageButton botaobf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catfps);
        getSupportActionBar().hide();

        botaoCate = findViewById(R.id.btncatfps);
        botaoHom = findViewById(R.id.btnhomefps);
        botaoLanc = findViewById(R.id.btnlancfps);
        botaobf = findViewById(R.id.btnbf2);

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

        botaobf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ho = new Intent(getApplicationContext(), Bf2042.class);
                startActivity(ho);
            }

        });
    }
}
