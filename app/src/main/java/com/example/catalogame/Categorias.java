package com.example.catalogame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Categorias extends AppCompatActivity {

    ImageButton botaoHome;
    ImageButton botaoLanca;
    ImageButton botaoUser;
    Button botaoterror;
    Button botaofps;
    Button botaosandbox;
    SensorManager sensorManager;
    Sensor sensor;
    SensorEventListener sensorEventListener;
    int mov = 0;
    Vibrator vibrar;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_categorias);
        
        //adicionando o sensor
        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if(sensor == null)
            finish();
        vibrar = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        sensorEventListener = new SensorEventListener(){
            @Override
            public void onSensorChanged(SensorEvent sensorevent) {
                float x = sensorevent.values[0];
                float y = sensorevent.values[1];
                float z = sensorevent.values[2];
                System.out.println("Valor GiroX" + x);
                if(x<-5 && mov == 0) {
                    vibrar.vibrate(1000);
                    mov++;
                } else if(x>-5 && mov == 1) {
                    vibrar.vibrate(500);
                    mov++;
                    
                }
                
                if(mov == 2) {
                    vibrar.vibrate(300);
                    mov = 0;
                }
            }
            
            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
            
            }
        
        
        };
        Start();
        
        botaoHome = findViewById(R.id.btnhome2);
        botaoLanca = findViewById(R.id.btnlanc2);
        botaoterror = findViewById(R.id.btnterror);
        botaofps = findViewById(R.id.btnfps);
        botaosandbox = findViewById(R.id.btnsandbox);
        botaoUser = findViewById(R.id.btnusercat);
        
        botaoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent home = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(home);
            }
            
        });
        
        botaoUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent user = new Intent(getApplicationContext(), Usuario.class);
                startActivity(user);
            }
            
        });
        
        botaoLanca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent lancam = new Intent(getApplicationContext(), Lancamentos.class);
                startActivity(lancam);
            }
            
        });
        
        botaoterror.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent telterror = new Intent(getApplicationContext(), CatTerror.class);
                startActivity(telterror);
            }
            
        });

        botaofps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent telfps = new Intent(getApplicationContext(), Catfps.class);
                startActivity(telfps);
            }

        });

        botaosandbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent telsandbox = new Intent(getApplicationContext(), CatSndbox.class);
                startActivity(telsandbox);
            }

        });
    }
    
    //MÉTODOS DO ACELEROMETRO
    private void Start() {
        sensorManager.registerListener(sensorEventListener,sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }
    
    private void Stop() { sensorManager.unregisterListener(sensorEventListener); }
    
    @Override
    protected void onPause() {
        super.onPause();
        Stop();
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        Start();
    }
}
