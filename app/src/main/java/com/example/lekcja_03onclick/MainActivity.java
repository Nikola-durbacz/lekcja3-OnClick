
package com.example.lekcja_03onclick;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplay = findViewById(R.id.textView7);

        int[] digitButtonIds = {
                R.id.button52,
                R.id.button49,
                R.id.button50,
                R.id.button48,
                R.id.button43,
                R.id.button44,
                R.id.button45,
                R.id.button40,
                R.id.button41,
                R.id.button42
        };

        View.OnClickListener digitListener = v -> {
            Button clickedButton = (Button) v;
            String digit = clickedButton.getText().toString();
            appendSymbol(digit);
        };

        for (int id : digitButtonIds) {
            findViewById(id).setOnClickListener(digitListener);
        }
    }

    private void appendSymbol(String symbol) {
        String currentText = tvDisplay.getText().toString();

        if (currentText.equals("0")) {
            tvDisplay.setText(symbol);
        } else {
            tvDisplay.setText(currentText + symbol);
        }
    }
}
