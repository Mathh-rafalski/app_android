package com.example.nodeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.idComp);
    }

    public void Comp(View view) {
        Intent intent = new Intent(MainActivity.this, Compromisso.class);
        startActivity(intent);
    }
    public void addComp(View view) {
        Intent intent = new Intent(MainActivity.this, addCompromisso.class);
        startActivity(intent);
    }
}
