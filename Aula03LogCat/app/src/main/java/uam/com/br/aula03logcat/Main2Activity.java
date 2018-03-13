package uam.com.br.aula03logcat;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private Button btnScreen1, btnClose, btnGoogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("RAM","Screen 2: onCreate");
        setContentView(R.layout.activity_main2);

        btnScreen1 = (Button) findViewById(R.id.btnScreen1);
        btnScreen1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent screen1 = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(screen1);
            }
        });

        btnClose = (Button) findViewById(R.id.btnDestroy);
        btnClose.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnGoogle = (Button) findViewById(R.id.btnNav);
        btnGoogle.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent google = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(google);
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i("Ram", "Screen 2: onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("RAM","Screen 2: onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("RAM","Screen 2: onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("RAM","Screen 2: onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("RAM","Screen 2: onDestroy");
    }

    @Override
    public void onClick(View view) {

    }
}
