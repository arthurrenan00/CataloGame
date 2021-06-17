package com.example.catalogame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;

public class Minecraft extends AppCompatActivity {

    ImageButton botaoCate;
    ImageButton botaoHom;
    ImageButton botaoLanc;
    ImageButton botaoPsmine;
    ImageButton botaoXboxmine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minecraft);
        getSupportActionBar().hide();

        botaoCate = findViewById(R.id.btncatmine);
        botaoHom = findViewById(R.id.btnhomemine);
        botaoLanc = findViewById(R.id.btnlancmine);
        botaoPsmine = findViewById(R.id.btnpsmine);
        botaoXboxmine = findViewById(R.id.btnxboxmine);

        WebView mWebView = (WebView) findViewById(R.id.webviewRm);

        String text = "<html><style type=\"text/css\">p{text-align:justify}</style><body>"
                + "<p>"
                + getString(R.string.reviewMine)
                + "</p> "
                + "</body></html>";

        mWebView.loadData(text, "text/html", "utf-8");

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

        botaoPsmine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://store.playstation.com/pt-br/product/UP4433-CUSA00744_00-MINECRAFTPS40001");
                Intent it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(Intent.createChooser(it, getString(R.string.chNav)));

            }
        });

        botaoXboxmine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.xbox.com/pt-BR/games/minecraft");
                Intent it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(Intent.createChooser(it, getString(R.string.chNav)));

            }
        });
    }
}