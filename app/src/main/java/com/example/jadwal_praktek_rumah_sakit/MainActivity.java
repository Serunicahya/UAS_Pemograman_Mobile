package com.example.jadwal_praktek_rumah_sakit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView nama;
    Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nama = findViewById(R.id.tvNama);
        btnLogout = findViewById(R.id.buttonLogout);
        final com.example.jadwal_praktek_rumah_sakit.SessionManager sm = new com.example.jadwal_praktek_rumah_sakit.SessionManager(
                getApplicationContext());
        nama.setText("Selamat Datang, " + sm.getNama());
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sm.logoutUser();
                Intent i = new Intent(getApplicationContext(),
                        LoginActivity.class);
                startActivity(i);
            }
        });

    }
}