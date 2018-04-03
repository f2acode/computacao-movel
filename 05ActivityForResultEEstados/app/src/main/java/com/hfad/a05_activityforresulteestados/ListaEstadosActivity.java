package com.hfad.a05_activityforresulteestados;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;

public class ListaEstadosActivity extends ListActivity {

    private static final String EXTRA_ESTADO = "estado";
    private static final String EXTRA_RESULTADO = "result";
    private String estados[], estado;
    private int posicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_estados);


            estados = getResources().getStringArray(R.array.estados);

            setListAdapter(new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_single_choice, estados));

            estado = getIntent().getStringExtra(EXTRA_ESTADO);

            if(estado != null){
                posicao = Arrays.asList(estados).indexOf(estado);
                getListView().setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
                getListView().setItemChecked(posicao, true);
            }


    }

    protected void onListItemClick(ListView l, View v, int posicao, long id){
        String result = l.getItemAtPosition(posicao).toString();
        Intent intent = new Intent();
        intent.putExtra(EXTRA_ESTADO, result);
        setResult(RESULT_OK, intent);
        finish();
    }

}
