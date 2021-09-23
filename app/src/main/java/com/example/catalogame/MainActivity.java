package com.example.catalogame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

public class MainActivity extends AppCompatActivity {

    ImageButton botaoCategorias;
    ImageButton botaoLanc;
    ImageButton botaoMine;
    ImageButton botaoUser;
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
        botaoUser = findViewById(R.id.btnuserh);
        
        
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
        
        botaoUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent user = new Intent(getApplicationContext(), Usuario.class);
                startActivity(user);
            }
            
        });
    }


}
