package com.hfad.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TelaFinalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_final);

        apresentarFinalizacao();
    }

    public void apresentarFinalizacao(){

        Intent intent = getIntent();
        String nomeJogador = intent.getStringExtra("nomeJogador");
        int pontuacao = intent.getIntExtra("pontuacao", 0);

        TextView tv_pontuacao = (TextView) findViewById(R.id.tv_pontuacao);
        tv_pontuacao.setText(
                String.format(nomeJogador + ", sua pontuação é de " + pontuacao + " pontos"));
    }

    public void voltarMenuPrincipal(View view){
        Intent intent = new Intent(this, TelaInicialActivity.class);
        startActivity(intent);
    }
}
