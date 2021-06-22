package com.example.catalogame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class CatSandbox extends AppCompatActivity {

    ImageButton botaoCate;
    ImageButton botaoHom;
    ImageButton botaoLanc;
    ImageButton botaoMine;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_sandbox);
        getSupportActionBar().hide();

        botaoCate = findViewById(R.id.btncatterror);
        botaoHom = findViewById(R.id.btnhometerror);
        botaoLanc = findViewById(R.id.btnlancterror);
        botaoMine = findViewById(R.id.btnmine2);
        
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

        botaoMine.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent mine = new Intent(getApplicationContext(), Minecraft.class);
                startActivity(mine);
            }
        });
    }
}
