package com.mrvn.guia3lab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import java.util.ArrayList;

import static com.mrvn.guia3lab.MainActivity.mensaje;
public class Agregar extends AppCompatActivity {
    Button Procesar;
    EditText Nombre;
    ProgressBar Barra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
        Procesar = findViewById(R.id.btnProcesar);
        Barra = findViewById(R.id.Barra);
        Nombre = findViewById(R.id.valorNombre);

        Procesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Nombre.getText().length()>0){
                    setProgressValue(0);
                }else{
                    validacion();
                }
            }
        });
    }
    private void setProgressValue(final int progress){
        Barra.setProgress(progress);
        Thread  thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                if(progress+20 == 100) {
                    runOnUiThread(new Runnable() {
                        public void run() {
                            //Codigo ha ejecuta al finalizar la carga
                            Intent Enviar = new Intent();
                            Enviar.putExtra(mensaje, Nombre.getText().toString());
                            setResult(RESULT_OK, Enviar);
                            finish();
                        }
                    });
                }
                setProgressValue(progress+20);
            }
        });
        thread.start();
    }
    public void validacion(){
        Toast.makeText(this, "No ha ingresado Nombre",Toast.LENGTH_SHORT).show();
    }
}
