package uam.com.br.apppesoidealimc;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

        //getting the values
        et_height = (EditText) findViewById(R.id.et_imc_height);
        et_weight = (EditText) findViewById(R.id.et_imc_weight);

        String stringHeight = et_height.getText().toString();
        String stringWeight = et_weight.getText().toString();

        Context context = getApplicationContext();

        if(stringHeight.isEmpty()){
            CharSequence warningHeight = "Necessária a altura!";
            Toast toast = Toast.makeText(context, warningHeight, Toast.LENGTH_SHORT);
            toast.show();
        }else if(stringWeight.isEmpty()){
            CharSequence warningWeight = "Necessário o peso!";
            Toast toast = Toast.makeText(context, warningWeight, Toast.LENGTH_SHORT);
            toast.show();
        }else{

            double height = 0.0, weight = 0.0;

            if(stringHeight.contains(",")){
                stringHeight = stringHeight.replaceAll(",",".");
                height = Double.valueOf(stringHeight);
            }else if(stringHeight.contains(".")){
                height = Double.valueOf(stringHeight);
            }else{
                height = Double.valueOf(stringHeight);
                height = height/100;
            }

            if(stringWeight.contains(",")){
                stringWeight = stringWeight.replaceAll(",",".");
                weight = Double.valueOf(stringWeight);
            }else if(!stringWeight.contains("\\.")){
                weight = Double.valueOf(stringWeight);
            }

            double imc = weight/(height * height);

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
}
