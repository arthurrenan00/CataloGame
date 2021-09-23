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

public class MainActivity extends AppCompatActivity  implements EnderecoAtual.OnTaskCompleted {

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

        
        
        mLocationButton = (Button) findViewById(R.id.btnlocalizacao);
        mLocationTextView = (TextView) findViewById(R.id.txtlocalizacao);
// Inicializa FusedLocationClient.
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(
                this);
// Recupera o estado da aplicação quando é recriado
        if (savedInstanceState != null) {
            mTrackingLocation = savedInstanceState.getBoolean(
                    TRACKING_LOCATION_KEY);
        }

// Listener do botão de localização.
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

        // Inicializa os callbacks da locations.
        mLocationCallback = new LocationCallback() {

            @Override
            public void onLocationResult(LocationResult locationResult) {
                // If tracking is turned on, reverse geocode into an address
                if (mTrackingLocation) {
                    new EnderecoAtual(MainActivity.this, MainActivity.this)
                            .execute(locationResult.getLastLocation());
                }
            }
        };
        //inicializa as preferências do usuário
        mPreferences = getSharedPreferences(PREFERENCIAS_NAME, MODE_PRIVATE);
        //recupera as preferencias
        recuperar();


        botaoCategorias = findViewById(R.id.btncat1);
        botaoLanc = findViewById(R.id.btnlanc1);
        botaoMine = findViewById(R.id.btnmine1);
        botaoRevil = findViewById(R.id.btnrevil1);
        botaobf2042 = findViewById(R.id.btnbf1);
        botaoSteam = findViewById(R.id.btnsteam);
        botaoXbox = findViewById(R.id.btnxbox);
        botaoPs = findViewById(R.id.btnps);
        botaoUser = findViewById(R.id.btnuserhome);
        
        
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

                         
    
    //

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
            // Set a loading text while you wait for the address to be
            // returned
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
            // Update the UI
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
