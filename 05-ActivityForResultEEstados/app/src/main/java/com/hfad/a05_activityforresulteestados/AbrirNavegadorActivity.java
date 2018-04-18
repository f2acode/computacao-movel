package com.hfad.a05_activityforresulteestados;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AbrirNavegadorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abrir_navegador);

        // pegando informações passadas
        Intent intent = getIntent();
        setUrlCompleto(intent.getStringExtra("estado"));
    }

    public void abrirNavegador(View view){

        EditText editText = (EditText) findViewById(R.id.url_base);
        TextView textView = (TextView) findViewById(R.id.url_complemento);

        if(editText.getText().toString().isEmpty())
        {
            editText.setError("O endereço não pode ser vazio!");
            editText.requestFocus();
        }
        else if(!editText.getText().toString().contains("http://"))
        {
            editText.setError("Informe um endereço iniciado em http://");
            editText.requestFocus();
        }
        else
        {
            String urlCompleta = editText.getText().toString() + textView.getText().toString();

            Intent intentNavegador  = new Intent(Intent.ACTION_VIEW, Uri.parse(urlCompleta));
            startActivity(intentNavegador);
        }
    }

    public void setUrlCompleto(String url){
        TextView textView = (TextView) findViewById(R.id.url_complemento);
        textView.setText("url");
    }
}
