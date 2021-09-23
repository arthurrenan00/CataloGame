package com.example.catalogame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.TextView;

public class Village extends AppCompatActivity {

    ImageButton botaoCate;
    ImageButton botaoHom;
    ImageButton botaoLanc;
    ImageButton botaoSteamvil;
    ImageButton botaoPsvil;
    TextView likerevil;
    ImageButton botaolikerevil;
    public static final String PREFS_NAME = "memoria";
    SharedPreferences settings;
    int contadorrevil = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        settings = getSharedPreferences(PREFS_NAME, 0);
        contadorrevil = settings.getInt("contadorrevil",contadorrevil);

        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_village);

        botaoCate = findViewById(R.id.btncatvil);
        botaoHom = findViewById(R.id.btnhomevil);
        botaoLanc = findViewById(R.id.btnlancvil);
        botaoSteamvil = findViewById(R.id.btnsteamvil);
        botaoPsvil = findViewById(R.id.btnpsvil);
        likerevil = findViewById(R.id.txtlikerevil);
        botaolikerevil = findViewById(R.id.btnlikerevil);
        atualizarLike();


        WebView mWebView = (WebView) findViewById(R.id.webviewRm1);

        String text = "<html><style type=\"text/css\">p{text-align:justify}</style><body>"
                + "<p>"
                + getString(R.string.reviewvil)
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

        botaoSteamvil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://store.steampowered.com/app/1196590/Resident_Evil_Village/");
                Intent it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(Intent.createChooser(it, getString(R.string.chNav)));

            }
        });

        botaoPsvil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://store.playstation.com/pt-br/product/UP0102-PPSA01556_00-VILLAGEFULLGAMEX");
                Intent it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(Intent.createChooser(it, getString(R.string.chNav)));

            }
        });

        botaolikerevil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contadorrevil++;
                atualizarLike();
                settings.edit().putInt("contadorrevil", contadorrevil).apply();

            }
        });
    }

    private void atualizarLike() {
        String s = Integer.toString(contadorrevil);
        likerevil.setText(s);
    }
}
