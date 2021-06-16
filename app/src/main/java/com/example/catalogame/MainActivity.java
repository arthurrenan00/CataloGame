package com.example.catalogame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton botaoCategorias;
    ImageButton botaoLanc;
    ImageButton botaoMine;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // remove a action bar
        setContentView(R.layout.activity_main);

        botaoCategorias = findViewById(R.id.btncat1);
        botaoLanc = findViewById(R.id.btnlanc1);
        botaoMine = findViewById(R.id.btnmine1);

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
    }
    
    public void abrirSteam(View view)
    {
	Uri uri = Uri.parse("https://store.steampowered.com/?l=portuguese");
	Intent it = new Intent(Intent.ACTION_VIEW,uri);
	startActivity(Intent.createChooser(R.string.chNav));
    }
    
    public void abrirXbox(View view)
    {
	Uri uri = Uri.parse("https://www.xbox.com/pt-BR/games/all-games");
	Intent it = new Intent(Intent.ACTION_VIEW,uri);
	startActivity(Intent.createChooser(R.string.chNav));
    }
    
    public void abrirPsStore(View view)
    {
	Uri uri = Uri.parse("https://store.playstation.com/pt-br/latest");
	Intent it = new Intent(Intent.ACTION_VIEW,uri);
	startActivity(Intent.createChooser(R.string.chNav));
    }
}
