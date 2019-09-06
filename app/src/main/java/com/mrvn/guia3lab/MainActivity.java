package com.mrvn.guia3lab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button Agregar, verLista, misDatos;
    public static String mensaje="vacio";
    public static ArrayList<String> valores = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Agregar = findViewById(R.id.btnAgregar);
        verLista = findViewById(R.id.btnVerLista);
        misDatos = findViewById(R.id.btnMisDatos);

        misDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), MisDatos.class );
                startActivity(i);
            }
        });
        verLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), VerListado.class);
                startActivity(i);;
            }
        });
        Agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), com.mrvn.guia3lab.Agregar.class);
                startActivityForResult(i,0);
            }
        });

        //mostrartoas();
    }
    public void onActivityResult(int RequestCode, int ResultCode, Intent datos) {
        super.onActivityResult(RequestCode, ResultCode, datos);
        if (ResultCode == RESULT_OK){
            valores.add(datos.getStringExtra(mensaje));
        mostrartoast(1);}
    }

    public void mostrartoast(int v){
        if (v==1) {
            Toast.makeText(this, "Nombre guardado correctamente", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Ocurrio un problema", Toast.LENGTH_SHORT).show();
        }
    }
}
