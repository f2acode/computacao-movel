package com.hfad.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class TelaInicialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
    }

    public void jogar(View view){
        EditText etNomeJogador = (EditText) findViewById(R.id.et_nome_jogador);
        String nomeJogador = etNomeJogador.getText().toString();

        Intent intentPerguntas = new Intent(this, PerguntasActivity.class);
        intentPerguntas.putExtra("nomeJogador", nomeJogador);

        startActivity(intentPerguntas);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.sobre:
                Intent intentSobre = new Intent(this, SobreActivity.class);
                startActivity(intentSobre);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
