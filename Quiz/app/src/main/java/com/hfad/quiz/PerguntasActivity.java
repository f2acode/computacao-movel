package com.hfad.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PerguntasActivity extends AppCompatActivity {

    String nomeJogador = "";
    List<PerguntaModel> perguntas = new ArrayList<PerguntaModel>();
    List<Integer> respostasJogador = new ArrayList<>();
    int pontuacaoFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perguntas);

        setarNomeJogador();
        setarPerguntas();
        mostrarNovaPergunta();
    }

    public void setarNomeJogador(){
        Intent essaIntent = getIntent();
        nomeJogador = essaIntent.getStringExtra("nomeJogador");

        TextView tvNomeJogador = (TextView) findViewById(R.id.tv_nome_usuario);
        tvNomeJogador.setText("Jogador: " + nomeJogador);
    }

    public void setarPerguntas(){

        List<String> alternativas = Arrays.asList(getResources().getStringArray(R.array.alternativas));
        List<String> textosPerguntas = Arrays.asList(getResources().getStringArray(R.array.perguntas));
        List<int[]> respostasCertas = Arrays.asList(getResources().getIntArray(R.array.respostas));

        for (int i = 0; i < textosPerguntas.size(); i++) {

            PerguntaModel pergunta = new PerguntaModel();
            pergunta.texto = textosPerguntas.get(i);
            pergunta.repostaCerta = respostasCertas.get(0)[i];
            pergunta.alternativas = alternativas.subList(perguntas.size() * 4, (perguntas.size() * 4)+4);

            perguntas.add(pergunta);
        }
    }

    public void mostrarNovaPergunta(){
        PerguntaModel pergunta = perguntas.get(respostasJogador.size());

        // inserindo o texto para a pergunta
        TextView tv_texto_pergunta = (TextView) findViewById(R.id.tv_texto_pergunta);
        tv_texto_pergunta.setText(String.valueOf(respostasJogador.size()+1) +" - "+ pergunta.texto);

        // inserindo o texto para as alternativas
        RadioGroup rg_alternativas = (RadioGroup) findViewById(R.id.rg_alternativas);

        for (int i = 0; i < rg_alternativas.getChildCount(); i++) {
            RadioButton rb_alternativa = (RadioButton)rg_alternativas.getChildAt(i);
            rb_alternativa.setId(i+1);
            rb_alternativa.setText(pergunta.alternativas.get(i));
        }
    }

    public void salvarEProxima(View view){

        //salva resposta
        RadioGroup rg_alternativas = (RadioGroup) findViewById(R.id.rg_alternativas);
        respostasJogador.add(
                rg_alternativas.getCheckedRadioButtonId());

        if(respostasJogador.size() != perguntas.size()){
            mostrarNovaPergunta();
        }else{
            salvarEFinalizar();
        }
    }

    public void salvarEFinalizar(){
        //contabiliza a pontuação
        for (int i = 0; i < respostasJogador.size(); i++) {
            if(respostasJogador.get(i) == perguntas.get(i).repostaCerta){
                pontuacaoFinal++;
            }
        }

        Intent intentTelaFinal = new Intent(this, TelaFinalActivity.class);
        intentTelaFinal.putExtra("nomeJogador", nomeJogador);
        intentTelaFinal.putExtra("pontuacao", pontuacaoFinal);
        startActivity(intentTelaFinal);
    }
}
