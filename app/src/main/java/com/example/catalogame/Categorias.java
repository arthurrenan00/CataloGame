package com.example.catalogame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Categorias extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_categorias);
    }
}