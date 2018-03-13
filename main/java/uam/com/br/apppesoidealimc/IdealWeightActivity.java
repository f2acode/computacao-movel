package uam.com.br.apppesoidealimc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.ObjectInputStream;

public class IdealWeightActivity extends AppCompatActivity {

    EditText inputHeight;
    TextView idealWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ideal_weight);
    }

    public void calculateIMC(View view){

        Intent intent = this.getIntent();

        double factor = intent.getExtras().getDouble("factor");
        Log.i("factor", String.valueOf(factor));

        // get the height
        inputHeight = (EditText) findViewById(R.id.input_height);
        double height = Double.valueOf(inputHeight.toString());

        // calculate
        double weight = (height-100)*factor;

        // define the weight
        idealWeight = (TextView) findViewById(R.id.ideal_weight);
        idealWeight.setText(String.valueOf(weight));
    }
}
