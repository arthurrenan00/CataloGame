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

public class Minecraft extends AppCompatActivity {

    ImageButton botaoCate;
    ImageButton botaoHom;
    ImageButton botaoLanc;
    ImageButton botaoPsmine;
    ImageButton botaoXboxmine;
    TextView likemine;
    ImageButton botaolikemine;
    public static final String PREFS_NAME = "memoria";
    SharedPreferences settings;
    int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        settings = getSharedPreferences(PREFS_NAME, 0);
        contador = settings.getInt("contador",contador);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minecraft);
        getSupportActionBar().hide();

        botaoCate = findViewById(R.id.btncatmine);
        botaoHom = findViewById(R.id.btnhomemine);
        botaoLanc = findViewById(R.id.btnlancmine);
        botaoPsmine = findViewById(R.id.btnpsmine);
        botaoXboxmine = findViewById(R.id.btnxboxmine);
        likemine = findViewById(R.id.txtlikemine);
        botaolikemine = findViewById(R.id.btnlikemine);
        atualizarLike();

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

        botaolikemine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador++;
                atualizarLike();
                settings.edit().putInt("contador", contador).apply();

            }
        });

    }

    private void atualizarLike() {
        String s = Integer.toString(contador);
        likemine.setText(s);
    }

}
