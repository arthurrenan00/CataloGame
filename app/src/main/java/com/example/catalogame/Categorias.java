package com.example.catalogame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Categorias extends AppCompatActivity {

    ImageButton botaoHome;
    ImageButton botaoLanca;
    Button botaoterror;
    Button botaofps;
Button botaosandbox;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_categorias);
        
        botaoHome = findViewById(R.id.btnhome2);
        botaoLanca = findViewById(R.id.btnlanc2);
        botaoterror = findViewById(R.id.btnterror);
        botaofps = findViewById(R.id.btnfps);
        botaosandbox = findViewById(R.id.btnsandbox);
        
        botaoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent home = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(home);
            }
            
        });
        
        botaoLanca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent lancam = new Intent(getApplicationContext(), Lancamentos.class);
                startActivity(lancam);
            }
            
        });
        
        botaoterror.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent telterror = new Intent(getApplicationContext(), CatTerror.class);
                startActivity(telterror);
            }
            
        });

        botaofps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent telfps = new Intent(getApplicationContext(), Catfps.class);
                startActivity(telfps);
            }

        });

        botaosandbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent telsandbox = new Intent(getApplicationContext(), CatSndbox.class);
                startActivity(telsandbox);
            }

        });
    }
}
