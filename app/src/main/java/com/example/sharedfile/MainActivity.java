package com.example.sharedfile;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    String name;
    int counter;
    TextView tvCounter;
    Button btnCounter, btnReset, btnExit;
    EditText etName;

    /**
     * Called when the activity is first created.
     * Initializes UI elements and retrieves stored preferences.
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *                           previously being shut down, this Bundle contains the most recent data.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCounter = findViewById(R.id.tvCounter);
        btnCounter = findViewById(R.id.btnCounter);
        btnReset = findViewById(R.id.btnReset);
        btnExit = findViewById(R.id.btnExit);
        etName = findViewById(R.id.etName);

        SharedPreferences settings = getSharedPreferences("PREFS_NAME", MODE_PRIVATE);
        counter = settings.getInt("counter", -100);
        tvCounter.setText(counter + "");
        name = settings.getString("name", "notWorking");
        etName.setText(name);
    }

    /**
     * Increments the counter value and updates the displayed text.
     *
     * @param view The button view that was clicked.
     */
    public void clickedBtnCount(View view) {
        counter++;
        tvCounter.setText(counter + "");
    }

    /**
     * Resets the counter to zero and updates the displayed text.
     *
     * @param view The button view that was clicked.
     */
    public void clickedBtnReset(View view) {
        counter = 0;
        tvCounter.setText(counter + "");
    }

    /**
     * Saves the current counter value and name to SharedPreferences and exits the application.
     *
     * @param view The button view that was clicked.
     */
    public void clickedBtnExit(View view) {
        SharedPreferences settings = getSharedPreferences("PREFS_NAME", MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("counter", counter);
        name = etName.getText().toString();
        editor.putString("name", name);
        editor.commit();
        finish();
    }
}
