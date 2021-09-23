package com.example.catalogame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class CatTerror extends AppCompatActivity {

    ImageButton botaoCate;
    ImageButton botaoHom;
    ImageButton botaoLanc;
    ImageButton botaoRevil;
    ImageButton botaoUser;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_terror);
        getSupportActionBar().hide();

        botaoCate = findViewById(R.id.btncatterror);
        botaoHom = findViewById(R.id.btnhometerror);
        botaoLanc = findViewById(R.id.btnlancterror);
        botaoRevil = findViewById(R.id.btnrevil2);
        botaoUser = findViewById(R.id.btnuserterror);

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

        botaoRevil.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent revil = new Intent(getApplicationContext(), Village.class);
                startActivity(revil);
            }
        });
    }
}
