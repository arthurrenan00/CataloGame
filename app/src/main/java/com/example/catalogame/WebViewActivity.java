package com.example.catalogame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.net.UrlQuerySanitizer;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_web_view);

        Intent intent = getIntent();
        Uri uri = intent.getData();
        WebView wv = (WebView) findViewById(R.id.webview1);
        //opcional
        wv.getSettings().setJavaScriptEnabled(true);

        wv.setWebViewClient(new WebViewClient());
        wv.loadUrl(uri.toString());

    }
}