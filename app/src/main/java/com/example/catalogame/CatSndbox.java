package com.example.catalogame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class CatSndbox extends AppCompatActivity {

    ImageButton botaoCate;
    ImageButton botaoHom;
    ImageButton botaoLanc;
    ImageButton botaomine;
    ImageButton botaoUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_sndbox);
        getSupportActionBar().hide();

        botaoCate = findViewById(R.id.btncatsandbox);
        botaoHom = findViewById(R.id.btnhomesandbox);
        botaoLanc = findViewById(R.id.btnlancsandbox);
        botaomine = findViewById(R.id.btnmine2);
        botaoUser = findViewById(R.id.btnusercatsndbox);

        botaoCate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent cate = new Intent(getApplicationContext(), Categorias.class);
                startActivity(cate);
            }

        });
        
        botaoUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent user = new Intent(getApplicationContext(), Usuario.class);
                startActivity(user);
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

        botaomine.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent mine = new Intent(getApplicationContext(), Minecraft.class);
                startActivity(mine);
            }
        });

    }
}
