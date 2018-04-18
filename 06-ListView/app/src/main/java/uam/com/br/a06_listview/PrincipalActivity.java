package uam.com.br.a06_listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }

    public void botao1(View view){
        Intent exemplo1 = new Intent(this, Exemplo1Activity.class);
        startActivity(exemplo1);
    }

    public void botao2(View view){
        Intent exemplo1 = new Intent(this, Exemplo2Activity.class);
        startActivity(exemplo1);
    }
}
