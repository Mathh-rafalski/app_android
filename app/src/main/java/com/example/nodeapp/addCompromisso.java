package com.example.nodeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class addCompromisso extends AppCompatActivity {
    EditText edtDes;
    EditText edtData;
    EditText edtHora;
    SimpleDateFormat sdf;
    SimpleDateFormat sdf2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_compromisso);
        edtData = findViewById(R.id.edtData);
        edtDes = findViewById(R.id.edtDes);
        edtHora = findViewById(R.id.edtHora);
        sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        sdf2 = new SimpleDateFormat("dd-MM-yyyy hh:mm");

    }

    public void Salvar(View view) {
        Tarefa t = new Tarefa();
        String dataHora;
            String data = edtData.getText().toString();
            String hora = edtHora.getText().toString();
            dataHora = data + " " + hora;
            try {
                if (dataHora.contains("/")) {
                    dataHora = dataHora.replace("/","-");
                }
                System.out.println(dataHora);
                Date dat = sdf2.parse(dataHora);
                System.out.println(dat);
                t.setDataHora(sdf.format(dat));

            }catch (ParseException pe) {
                pe.printStackTrace();
            }
        t.setDescricao(edtDes.getText().toString());
        Gson gson = new Gson();
        String json = gson.toJson(t);
        String a = String.valueOf(new HttpPost().execute(json));
        if (a != null) {
            TextView tx = findViewById(R.id.idSalvo);
            tx.setText("Salvo");
        }
    }
}
