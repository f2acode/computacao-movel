package uam.com.br.apppesoidealimc;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class IMCActivity extends AppCompatActivity {

    EditText et_height, et_weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);
    }

    public void calculateIMC(View view){
        et_height = (EditText) findViewById(R.id.et_imc_height);
        et_weight = (EditText) findViewById(R.id.et_imc_weight);

        double height = Double.valueOf(et_height.getText().toString());
        double weight = Double.valueOf(et_weight.getText().toString());

        double imc = weight/(height * height);

        Context context = getApplicationContext();
        CharSequence textIMC = "";
        int duration = Toast.LENGTH_SHORT;

        if(imc < 18.5){
            textIMC = "Baixo peso";
        }else if(imc >= 18.5 && imc <= 24.9){
            textIMC = "Peso normal";
        }else if(imc >= 25 && imc <= 29.9){
            textIMC = "Sobrepeso";
        }else if(imc >= 30 && imc <= 34.9){
            textIMC = "Obesidade grau I";
        }else if(imc >= 35 && imc <= 39.9){
            textIMC = "Obesidade grau II";
        }else if(imc > 40){
            textIMC = "Obesidade grau III";
        }

        Toast toast = Toast.makeText(context, textIMC, Toast.LENGTH_SHORT);
        toast.show();
    }
}
