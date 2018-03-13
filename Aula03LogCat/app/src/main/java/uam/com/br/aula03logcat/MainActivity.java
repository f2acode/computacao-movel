package uam.com.br.aula03logcat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnScreen2;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.i("RAM", "Screen 1: onCreate");
        setContentView(R.layout.activity_main);

        btnScreen2 = (Button) findViewById(R.id.btnScreen2);
        btnScreen2.setOnClickListener(this);
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i("Ram", "Screen 1: onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("RAM","Screen 1: onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("RAM","Screen 1: onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("RAM","Screen 1: onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("RAM","Screen 1: onDestroy");
    }

    @Override
    public void onClick(View view) {
        Intent screen2 = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(screen2);
    }
}
