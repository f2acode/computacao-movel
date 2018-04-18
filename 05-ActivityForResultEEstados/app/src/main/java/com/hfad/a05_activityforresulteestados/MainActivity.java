package com.hfad.a05_activityforresulteestados;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_ESTADOS = 1;
    String estadoSelecionado = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void irIntentNavegador(View view){
        Intent intent = new Intent(this, AbrirNavegadorActivity.class);
        intent.putExtra("estado", estadoSelecionado);
        startActivity(intent);
    }

    public void irIntentEstados(View view){
        Intent intent = new Intent(this, ListaEstadosActivity.class);
        startActivityForResult(intent, REQUEST_ESTADOS);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent){

        if(requestCode == REQUEST_ESTADOS && resultCode == RESULT_OK){
            estadoSelecionado = "TODO";
            Log.i("data aqui",intent.toString());
        }

    }


}
