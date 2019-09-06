package com.mrvn.guia3lab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import static com.mrvn.guia3lab.MainActivity.mensaje;
public class MisDatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String  valor = "Prueba";
        setContentView(R.layout.activity_mis_datos);
        Intent Enviar = new Intent();
        Enviar.putExtra(mensaje, valor);
        setResult(RESULT_OK, Enviar);
    }
}
