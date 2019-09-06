package com.mrvn.guia3lab;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import static com.mrvn.guia3lab.MainActivity.valores;
public class VerListado extends AppCompatActivity {
    ListView Listado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_listado);
        Listado = findViewById(R.id.Listado);
        ArrayAdapter <String> AdaptadorListado = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        AdaptadorListado.addAll(valores);
        Listado.setAdapter(AdaptadorListado);
        AdaptadorListado.notifyDataSetChanged();
    }
}
