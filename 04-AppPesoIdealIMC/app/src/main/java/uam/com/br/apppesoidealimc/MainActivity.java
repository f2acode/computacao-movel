package uam.com.br.apppesoidealimc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // Todo mask on all the inputs
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void idealWeightMan(View view){
        Intent intent = new Intent(this, IdealWeightActivity.class);
        intent.putExtra("factor", 0.90);
        startActivity(intent);
    }

    public void idealWeightWoman(View view){
        Intent intent = new Intent(this, IdealWeightActivity.class);
        intent.putExtra("factor", 0.85);
        startActivity(intent);
    }

    public void IMC(View view){
        Intent intent = new Intent(this, IMCActivity.class);
        startActivity(intent);
    }

    public void about(View view){
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }
}
