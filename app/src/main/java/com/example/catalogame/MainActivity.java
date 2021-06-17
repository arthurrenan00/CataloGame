package com.example.catalogame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import java.io.UnsupportedEncodingException;import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    ImageButton botaoCategorias;
    ImageButton botaoLanc;
    ImageButton botaoMine;
    ImageButton botaoSteam;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // remove a action bar
        setContentView(R.layout.activity_main);

        botaoCategorias = findViewById(R.id.btncat1);
        botaoLanc = findViewById(R.id.btnlanc1);
        botaoMine = findViewById(R.id.btnmine1);
        botaoSteam = findViewById(R.id.btnsteam);

        botaoCategorias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent cat = new Intent(getApplicationContext(), Categorias.class);
                startActivity(cat);
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

        botaoSteam.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://store.steampowered.com/?l=portuguese");
                Intent it = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(Intent.createChooser(it, getString(R.string.chNav)));

            }
        });
    }


}
