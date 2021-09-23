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

public class Bf2042 extends AppCompatActivity {

    ImageButton botaoCate;
    ImageButton botaoHom;
    ImageButton botaoLanc;
    ImageButton botaoUser;
    ImageButton botaoSteambf;
    ImageButton botaoPsbf;
    ImageButton botaoXboxbf;
    TextView likebf2042;
    ImageButton botaolikebf2042;
    public static final String PREFS_NAME = "memoria";
    SharedPreferences settings;
    int contadorbf2042 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        settings = getSharedPreferences(PREFS_NAME, 0);
        contadorbf2042 = settings.getInt("contadorbf2042",contadorbf2042);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bf2042);
        getSupportActionBar().hide();

        botaoCate = findViewById(R.id.btncatbf2042);
        botaoHom = findViewById(R.id.btnhomebf2042);
        botaoLanc = findViewById(R.id.btnlancbf2041);
        botaoSteambf = findViewById(R.id.btnsteambf2042);
        botaoPsbf = findViewById(R.id.btnpsbf2042);
        botaoXboxbf = findViewById(R.id.btnxboxbf2042);
        botaoUser = findViewById(R.id.btnuserbf2042);
        likebf2042 = findViewById(R.id.txtlikebf2042);
        botaolikebf2042 = findViewById(R.id.btnlikebf2042);
        atualizarLike();

        WebView mWebView = (WebView) findViewById(R.id.webviewRm2);

        String text = "<html><style type=\"text/css\">p{text-align:justify}</style><body>"
                + "<p>"
                + getString(R.string.reviewbf2042)
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
        
        botaoUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent user = new Intent(getApplicationContext(), Usuario.class);
                startActivity(user);
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

        botaoSteambf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://store.steampowered.com/app/1517290/Battlefield_2042/");
                Intent it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(Intent.createChooser(it, getString(R.string.chNav)));

            }
        });

        botaoPsbf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://store.playstation.com/pt-br/product/UP0006-PPSA01464_00-KSULTPREORDER000");
                Intent it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(Intent.createChooser(it, getString(R.string.chNav)));

            }
        });

        botaoXboxbf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.microsoft.com/pt-br/p/Battlefield2042UltimateEditionXboxOneXboxSeriesXS/9PHN3JW0TZQ7?rtc=1&activetab=pivot:overviewtab");
                Intent it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(Intent.createChooser(it, getString(R.string.chNav)));

            }
        });

        botaolikebf2042.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contadorbf2042++;
                atualizarLike();
                settings.edit().putInt("contadorbf2042", contadorbf2042).apply();

            }
        });
    }

    private void atualizarLike() {
        String s = Integer.toString(contadorbf2042);
        likebf2042.setText(s);
    }
}
