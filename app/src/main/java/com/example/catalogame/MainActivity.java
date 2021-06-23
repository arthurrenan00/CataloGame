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
    ImageButton botaoRevil;
    ImageButton botaobf2042;
    ImageButton botaoSteam;
    ImageButton botaoXbox;
    ImageButton botaoPs;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // remove a action bar
        setContentView(R.layout.activity_main);

        botaoCategorias = findViewById(R.id.btncat1);
        botaoLanc = findViewById(R.id.btnlanc1);
        botaoMine = findViewById(R.id.btnmine1);
        botaoRevil = findViewById(R.id.btnrevil1);
        botaobf2042 = findViewById(R.id.btnbf1);
        botaoSteam = findViewById(R.id.btnsteam);
        botaoXbox = findViewById(R.id.btnxbox);
        botaoPs = findViewById(R.id.btnps);

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

        botaoRevil.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent revil = new Intent(getApplicationContext(), Village.class);
                startActivity(revil);
            }
        });

        botaobf2042.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent bf2042 = new Intent(getApplicationContext(), Bf2042.class);
                startActivity(bf2042);
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

        botaoXbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.xbox.com/pt-BR/games/all-games");
                Intent it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(Intent.createChooser(it, getString(R.string.chNav)));

            }
        });

        botaoPs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://store.playstation.com/pt-br/latest");
                Intent it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(Intent.createChooser(it, getString(R.string.chNav)));

            }
        });
    }


}
