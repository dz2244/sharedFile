package com.example.sharedfile;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    String name ;
    int counter ;
    TextView tvCounter;
    Button btnCounter,btnReset,btnExit;
    EditText etName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCounter = findViewById(R.id.tvCounter);
        btnCounter = findViewById(R.id.btnCounter);
        btnReset = findViewById(R.id.btnReset);
        btnExit = findViewById(R.id.btnExit);
        etName = findViewById(R.id.etName);

        SharedPreferences settings =getSharedPreferences("PREFS_NAME",MODE_PRIVATE);
        SharedPreferences.Editor editor= settings.edit();
        counter = settings.getInt("counter",-100);
        tvCounter.setText (counter+"");
        name = settings.getString("name","notWorking");
        etName.setText(name);

    }

    public void clickedBtnCount(View view) {
        counter++;
        tvCounter.setText(counter+"");

    }

    public void clickedBtnReset(View view) {
        counter = 0 ;
        tvCounter.setText(counter+"");
    }

    public void clickedBtnExit(View view) {
        SharedPreferences settings =getSharedPreferences("PREFS_NAME",MODE_PRIVATE);
        SharedPreferences.Editor editor= settings.edit();
        editor.putInt("counter",counter);
        name = etName.getText().toString();
        editor.putString("name",name);
        editor.commit();
        finish();
    }
}