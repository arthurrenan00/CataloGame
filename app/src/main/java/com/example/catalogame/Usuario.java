package com.example.catalogame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Usuario extends AppCompatActivity {
    ImageButton botaoCate;
    ImageButton botaoHom;
    ImageButton botaoLanca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);
        
        botaoHome = findViewById(R.id.btnhomeu);
        botaoCate = findViewById(R.id.btnlancu);
        botaoLanca = findViewById(R.id.btnlancu);
        
        botaoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(home);
            }
            
        });
        
       botaoCate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cate = new Intent(getApplicationContext(), Categorias.class);
                startActivity(cate);
            }
            
        });
        
        botaoLanca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lancam = new Intent(getApplicationContext(), Lancamentos.class);
                startActivity(lancam);
            }
            
        });
    }
}
