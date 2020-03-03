package com.example.nodeapp;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Compromisso extends AppCompatActivity {
    ListView list;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compromisso);
        list = findViewById(R.id.list);
        List<Tarefa> lista = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        list.setAdapter(adapter);
        try {
            String json = new httpGet().execute().get();
            JsonArray arr = new Gson().fromJson(json, JsonArray.class);
            for (int i = 0; i < arr.size(); i++) {
                Tarefa t = new Tarefa();
                t.setDescricao(arr.get(i).getAsJsonObject().get("descricao").toString());
                String date = arr.get(i).getAsJsonObject().get("data_hora").getAsString();
                t.setDataHora(date);
                System.out.println(t.getDataHora());
                String tarefa = t.getDescricao() + "\n" + sdf.format(t.getDataHora());
                tarefa = tarefa.replace("\"", "");
                System.out.println(tarefa);
				
                adapter.add(tarefa);


            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}