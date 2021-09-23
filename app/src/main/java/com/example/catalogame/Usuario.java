package com.example.catalogame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
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

public class Usuario extends AppCompatActivity implements EnderecoAtual.OnTaskCompleted {

    public static final String PREFERENCIAS_NAME = "com.example.android.localizacao";
    private static final String TRACKING_LOCATION_KEY = "tracking_location";
    private static final int REQUEST_LOCATION_PERMISSION = 1;
    private static final String LATITUDE_KEY = "latitude";
    private static final String LONGITUDE_KEY = "longitude";
    private static final String LASTDATE_KEY = "data";

    private Button mLocationButton;
    private TextView mLocationTextView;
    private static final String LASTADRESS_KEY = "adress";
    private FusedLocationProviderClient mFusedLocationClient;
    private LocationCallback mLocationCallback;

    private boolean mTrackingLocation;

    private SharedPreferences mPreferences;
    private String lastLatitude = "";
    private String lastLongitude = "";
    private String lastAdress = "";
    
    ImageButton botaoCate;
    ImageButton botaoHome;
    ImageButton botaoLanca;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_usuario);
        
        mLocationButton = (Button) findViewById(R.id.btnlocalizacao);
        mLocationTextView = (TextView) findViewById(R.id.txtlocalizacao);
        // Inicializando o FusedLocationClient.
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(
                this);
        // Recuperando o estado da aplicação quando é recriado
        if (savedInstanceState != null) {
            mTrackingLocation = savedInstanceState.getBoolean(
                    TRACKING_LOCATION_KEY);
        }

        // onclickListener do botão
        mLocationButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (!mTrackingLocation) {
                    startTrackingLocation();
                } else {
                    stopTrackingLocation();
                }
            }
        });

        // Inicializando os callbacks da locations.
        mLocationCallback = new LocationCallback() {

            @Override
            public void onLocationResult(LocationResult locationResult) {
                
                if (mTrackingLocation) {
                    new EnderecoAtual(Usuario.this, Usuario.this)
                            .execute(locationResult.getLastLocation());
                }
            }
        };
        mPreferences = getSharedPreferences(PREFERENCIAS_NAME, MODE_PRIVATE);
        recuperar();

        
        botaoHome = findViewById(R.id.btnhomeu);
        botaoCate = findViewById(R.id.btnlancu);
        botaoLanca = findViewById(R.id.btnlancu);
        

        botaoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(home);
            }
            
        });
        
       botaoCate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cate = new Intent(getApplicationContext(), Categorias.class);
                startActivity(cate);
            }
            
        });
        
        botaoLanca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lancam = new Intent(getApplicationContext(), Lancamentos.class);
                startActivity(lancam);
            }
            
        });


    }



    //ESSA FUNÇÃO IRÁ GRAVAR NA MEMÓRIA INTERNA
    public void fGravarInterna(View view) {
        Intent it = new Intent(this, Gravar.class);
        it.putExtra(Armazenamentos.STORAGE_TYPE, Armazenamentos.Type.INTERNAL);
        startActivity(it);
    }


    //ESSA FUNÇÃO IRÁ LER NA MEMÓRIA INTERNA
    public void fLerInterna(View view) {
        Intent it = new Intent(this, Ler.class);
        it.putExtra(Armazenamentos.STORAGE_TYPE, Armazenamentos.Type.INTERNAL);
        startActivity(it);
    }

    //ESSA FUNÇÃO IRÁ GRAVAR NA MEMÓRIA EXTERNA
    public void fGravarExterna(View view) {
        Intent it = new Intent(this, Gravar.class);
        it.putExtra(Armazenamentos.STORAGE_TYPE, Armazenamentos.Type.EXTERNAL);
        startActivity(it);
    }

    //ESSA FUNÇÃO IRÁ LER NA MEMÓRIA EXTERNA
    public void fLerExterna(View view) {
        Intent it = new Intent(this, Ler.class);
        it.putExtra(Armazenamentos.STORAGE_TYPE, Armazenamentos.Type.EXTERNAL);
        startActivity(it);
    }
    
     private void startTrackingLocation() {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]
                            {Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_LOCATION_PERMISSION);
        } else {
            mTrackingLocation = true;
            mFusedLocationClient.requestLocationUpdates
                    (getLocationRequest(),
                            mLocationCallback,
                            null /* Looper */);
            
            mLocationTextView.setText(getString(R.string.endereco,
                    getString(R.string.loading), null, null,
                    System.currentTimeMillis()));
            mLocationButton.setText(R.string.parar_busca);
        }
    }

    private LocationRequest getLocationRequest() {
        LocationRequest locationRequest = new LocationRequest();
        locationRequest.setInterval(10000);
        locationRequest.setFastestInterval(5000);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        return locationRequest;
    }


    private void stopTrackingLocation() {
        if (mTrackingLocation) {
            mTrackingLocation = false;
            mLocationButton.setText(R.string.iniciar_busca);
            mLocationTextView.setText(R.string.hint);
        }
    }

    /**
     * SAVED INSTANCE NO APP
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putBoolean(TRACKING_LOCATION_KEY, mTrackingLocation);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_LOCATION_PERMISSION:
                // Permissão garantida
                if (grantResults.length > 0
                        && grantResults[0]
                        == PackageManager.PERMISSION_GRANTED) {
                    startTrackingLocation();
                } else {
                    Toast.makeText(this,
                            R.string.permissao_recusada,
                            Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }



    @Override
    public void onTaskCompleted(String[] result) {
        if (mTrackingLocation) {
            
            lastLatitude = result[1];
            lastLongitude = result[2];
            lastAdress = result[0];
            mLocationTextView.setText(getString(R.string.endereco,
                    lastAdress, lastLatitude, lastLongitude, System.currentTimeMillis()));
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mTrackingLocation) {
            stopTrackingLocation();
            mTrackingLocation = true;
            armazenar(lastLatitude, lastLongitude, lastAdress);
        }
    }

    @Override
    protected void onResume() {
        if (mTrackingLocation) {
            startTrackingLocation();
        }
        recuperar();
        super.onResume();
    }


    private void armazenar(String latitude, String longitude, String lastAdress) {
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putString(LATITUDE_KEY, latitude);
        preferencesEditor.putString(LONGITUDE_KEY, longitude);
        preferencesEditor.putLong(LASTDATE_KEY, System.currentTimeMillis());
        preferencesEditor.putString(LASTADRESS_KEY, lastAdress);
        preferencesEditor.apply();
    }

    private void recuperar() {
        lastLatitude = mPreferences.getString(LATITUDE_KEY, "");
        lastLongitude = mPreferences.getString(LONGITUDE_KEY, "");
        long time = mPreferences.getLong(LASTDATE_KEY, 0);
        lastAdress = mPreferences.getString(LASTADRESS_KEY, "");
        Toast.makeText(this,
                getString(R.string.endereco,
                        lastAdress, lastLatitude, lastLongitude, time),
                Toast.LENGTH_SHORT).show();

    }
}
